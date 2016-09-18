package com.viaplay.trailer;

import com.viaplay.trailer.clients.TmdbServiceClient;
import com.viaplay.trailer.clients.ViaplayServiceClient;
import com.viaplay.trailer.resources.TrailerResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.client.Client;

public class ServiceApplication extends Application<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {

    }

    @Override
    public void run(ServiceConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());
        client.property(ClientProperties.READ_TIMEOUT, 3000);
        ViaplayServiceClient viaplayServiceClient = new ViaplayServiceClient(client);
        TmdbServiceClient tmdbServiceClient = new TmdbServiceClient(client, configuration.getTmdbApiKey());

        environment.jersey().register(new TrailerResource(viaplayServiceClient, tmdbServiceClient));
    }
}
