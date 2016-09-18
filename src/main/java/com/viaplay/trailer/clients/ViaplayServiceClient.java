package com.viaplay.trailer.clients;

import com.viaplay.trailer.exceptions.BaseException;
import com.viaplay.trailer.exceptions.ViaplayEmptyResponseException;
import com.viaplay.trailer.exceptions.ViaplayNotRespondingException;
import com.viaplay.trailer.model.ViaplayContent;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import static com.viaplay.trailer.constants.ResponseStatusMsgs.VIA_PLAY_EMPTY_RESPONSE_MSG;
import static com.viaplay.trailer.constants.ResponseStatusMsgs.VIA_PLAY_TIME_OUT_MSG;
import static com.viaplay.trailer.model.StatusCode.SERVICE_UNAVAILABLE;

public class ViaplayServiceClient {

    private final Client client;

    public ViaplayServiceClient(Client client) {
        this.client = client;
    }

    public ViaplayContent getViaplayContent(String contentUrl) throws BaseException {
        try {
            ViaplayContent content = client.target(contentUrl).request(MediaType.APPLICATION_JSON).get(ViaplayContent.class);
            if (content == null) {
                throw new ViaplayEmptyResponseException(VIA_PLAY_EMPTY_RESPONSE_MSG, SERVICE_UNAVAILABLE);
            } else {
                return content;
            }
        }catch (Exception e){
            throw new ViaplayNotRespondingException(VIA_PLAY_TIME_OUT_MSG, SERVICE_UNAVAILABLE);
        }
    }

}
