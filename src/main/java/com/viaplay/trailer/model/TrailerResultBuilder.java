package com.viaplay.trailer.model;

import java.util.ArrayList;
import java.util.List;

public class TrailerResultBuilder {

    Status status;
    List<Trailer> trailers;

    public static TrailerResultBuilder aTrailerResult(){
        return new TrailerResultBuilder();
    }

    public TrailerResultBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public TrailerResultBuilder withTrailers(List<Trailer> trailers){
        this.trailers = trailers;
        return this;
    }

    public TrailerResultBuilder addTrailer(Trailer trailer) {
        if(this.trailers == null){
            this.trailers = new ArrayList<Trailer>();
        }
        this.trailers.add(trailer);
        return this;
    }

    public TrailerResult build(){
        return new TrailerResult(this.status, this.trailers);
    }
}
