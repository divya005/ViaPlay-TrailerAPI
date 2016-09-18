package com.viaplay.trailer.resources;

import com.google.common.base.Optional;
import com.viaplay.trailer.clients.TmdbServiceClient;
import com.viaplay.trailer.clients.ViaplayServiceClient;
import com.viaplay.trailer.exceptions.BaseException;
import com.viaplay.trailer.model.TrailerResult;
import com.viaplay.trailer.services.TrailerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import static com.viaplay.trailer.constants.ResponseStatusMsgs.EMPTY_CONTENT_URL_MSG;
import static com.viaplay.trailer.model.StatusCode.BAD_REQUEST;
import static com.viaplay.trailer.services.TrailerService.getErrorTrailerResult;

@Path("/trailer")
@Produces(MediaType.APPLICATION_JSON)
public class TrailerResource {

    public static final String CONTENT_URL_QUERY_PARAM = "content-url";
    private final ViaplayServiceClient viaplayServiceClient;
    private final TmdbServiceClient tmdbServiceClient;

    public TrailerResource(ViaplayServiceClient viaplayServiceClient, TmdbServiceClient tmdbServiceClient) {
        this.viaplayServiceClient = viaplayServiceClient;
        this.tmdbServiceClient = tmdbServiceClient;
    }

    @GET
    public TrailerResult findTrailers(@QueryParam(CONTENT_URL_QUERY_PARAM) Optional<String> contentUrl) {
        try {
            TrailerService trailerService = new TrailerService(viaplayServiceClient, tmdbServiceClient);
            if (!contentUrl.isPresent()) {
                return getErrorTrailerResult(BAD_REQUEST, EMPTY_CONTENT_URL_MSG);
            }
            return trailerService.getTrailers(contentUrl.get());
        }catch (BaseException e){
            return getErrorTrailerResult(e.getStatusCode(), e.getMsg());
        }
    }
}
