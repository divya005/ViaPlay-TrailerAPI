package com.viaplay.trailer.services;

import com.viaplay.trailer.clients.TmdbServiceClient;
import com.viaplay.trailer.clients.ViaplayServiceClient;
import com.viaplay.trailer.exceptions.BaseException;
import com.viaplay.trailer.exceptions.TmdbInvalidResponseException;
import com.viaplay.trailer.exceptions.ViaplayInvalidResponseException;
import com.viaplay.trailer.model.*;

import java.util.ArrayList;
import java.util.List;

import static com.viaplay.trailer.constants.ResponseStatusMsgs.*;
import static com.viaplay.trailer.model.StatusCode.IMDB_NOT_FOUND;
import static com.viaplay.trailer.model.StatusCode.OK;

public class TrailerService {

    public static final String YOUTUBE_URL_TEMPLATE = "https://www.youtube.com/watch?v=";
    public static final String YOU_TUBE = "YouTube";

    private final ViaplayServiceClient viaplayServiceClient;
    private final TmdbServiceClient tmdbServiceClient;

    public TrailerService(ViaplayServiceClient viaplayServiceClient, TmdbServiceClient tmdbServiceClient) {
        this.viaplayServiceClient = viaplayServiceClient;
        this.tmdbServiceClient = tmdbServiceClient;
    }

    public TrailerResult getTrailers(String contentUrl) throws BaseException {

        String imdbId = findImdb(viaplayServiceClient.getViaplayContent(contentUrl));
        String movieId = getMovieId(tmdbServiceClient.getTmdbFindResult(imdbId));
        List<YouTubeTrailer> youTubeTrailers = getYouTubeTrailer(tmdbServiceClient.getTmdbMovieresult(movieId));

        return TrailerResultBuilder.aTrailerResult()
                .withStatus(new Status(OK, ""))
                .withTrailers(buildTrailers(youTubeTrailers))
                .build();
    }

    private List<Trailer> buildTrailers(List<YouTubeTrailer> youTubeTrailers) {
        List<Trailer> trailers = new ArrayList<Trailer>();
        for (YouTubeTrailer youTubeTrailer : youTubeTrailers) {
            String link = buildYouTubeLink(youTubeTrailer.getSource());
            trailers.add(new Trailer(YOU_TUBE, link, youTubeTrailer.getName()));
        }
        return trailers;
    }

    private String buildYouTubeLink(String source) {
        return YOUTUBE_URL_TEMPLATE +source;
    }

    private String findImdb(ViaplayContent content) throws ViaplayInvalidResponseException {
        try {
            return content.getContentEmbedded().getViaplayBlocks().get(0).getBlockEmbedded().getViaplayProduct().getProductContent().getImdb().getId();
        }catch(Exception e){
            throw new ViaplayInvalidResponseException(IMDB_NOT_FOUND_MSG, IMDB_NOT_FOUND);
        }
    }

    private String getMovieId(TmdbFindResults tmdbFindResults) throws TmdbInvalidResponseException {
        try {
            return tmdbFindResults.getMovieResults().get(0).getId();
        }catch (Exception e){
            throw new TmdbInvalidResponseException(MOVIE_ID_NOT_FOUND_MSG, StatusCode.TRAILER_NOT_FOUND);
        }
    }

    private List<YouTubeTrailer> getYouTubeTrailer(TmdbMovieResult tmdbMovieresult) throws TmdbInvalidResponseException {
        try {
            return tmdbMovieresult.getTrailers().getYouTubeTrailers();
        }catch (Exception e){
            throw new TmdbInvalidResponseException(TRAILER_INFO_NOT_AVAILABLE_MSG, StatusCode.TRAILER_NOT_FOUND);
        }
    }

    public static TrailerResult getErrorTrailerResult(StatusCode statusCode, String statusReason){
        return TrailerResultBuilder.aTrailerResult()
                .withStatus(new Status(statusCode, statusReason))
                .build();
    }
}
