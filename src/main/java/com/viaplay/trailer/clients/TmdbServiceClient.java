package com.viaplay.trailer.clients;

import com.viaplay.trailer.exceptions.BaseException;
import com.viaplay.trailer.exceptions.TmdbEmptyResponseException;
import com.viaplay.trailer.exceptions.TmdbNotRespondingException;
import com.viaplay.trailer.model.StatusCode;
import com.viaplay.trailer.model.TmdbFindResults;
import com.viaplay.trailer.model.TmdbMovieResult;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import static com.viaplay.trailer.constants.ResponseStatusMsgs.*;

public class TmdbServiceClient {

    public static final String FIND_MOVIE_URL_TEMPLATE = "https://api.themoviedb.org/3/find/";
    public static final String GET_MOVIE_URL_TEMPLATE = "https://api.themoviedb.org/3/movie/";
    public static final String API_KEY_QUERY_PARAM = "api_key";
    public static final String APPEND_RESPONSE_QUERY_PARAM = "append_to_response";
    public static final String TRAILERS = "trailers";
    public static final String EXTERNAL_SOURCE_QUERY_PARAM = "external_source";
    public static final String IMDB_ID = "imdb_id";

    private final Client client;
    private final String apiKey;

    public TmdbServiceClient(Client client, String apiKey) {
        this.client = client;
        this.apiKey = apiKey;
    }

    public TmdbFindResults getTmdbFindResult(String ImdbId) throws BaseException {
        try {
            TmdbFindResults tmdbFindResults = client.target(FIND_MOVIE_URL_TEMPLATE + ImdbId)
                    .queryParam(EXTERNAL_SOURCE_QUERY_PARAM, IMDB_ID)
                    .queryParam(API_KEY_QUERY_PARAM, apiKey)
                    .request(MediaType.APPLICATION_JSON)
                    .get(TmdbFindResults.class);
            if(tmdbFindResults ==  null){
                throw new TmdbEmptyResponseException(TMDB_FIND_MOVIE_EMPTY_RESPONSE_MSG, StatusCode.SERVICE_UNAVAILABLE);
            } else{
                return tmdbFindResults;
            }
        }catch (Exception e){
            throw new TmdbNotRespondingException(TMDB_FIND_MOVIE_TIME_OUT_MSG, StatusCode.SERVICE_UNAVAILABLE);
        }
    }

    public TmdbMovieResult getTmdbMovieresult(String movieId) throws BaseException {
        try{
            TmdbMovieResult tmdbMovieResult = client.target(GET_MOVIE_URL_TEMPLATE + movieId)
                    .queryParam(API_KEY_QUERY_PARAM, apiKey)
                    .queryParam(APPEND_RESPONSE_QUERY_PARAM, TRAILERS)
                    .request(MediaType.APPLICATION_JSON)
                    .get(TmdbMovieResult.class);
            if(tmdbMovieResult ==  null){
                throw new TmdbNotRespondingException(TMDB_GET_MOVIE_EMPTY_RESPONSE_MSG, StatusCode.SERVICE_UNAVAILABLE);
            } else{
                return tmdbMovieResult;
            }
        }catch (Exception e){
            throw new TmdbEmptyResponseException(TMDB_GET_MOVIE_TIME_OUT_MSG, StatusCode.SERVICE_UNAVAILABLE);
        }
    }

}
