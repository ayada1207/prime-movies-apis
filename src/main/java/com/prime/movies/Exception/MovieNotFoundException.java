package com.prime.movies.Exception;

import org.bson.types.ObjectId;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String id){
        super("Movie found Not found with given ID: "+ id);
    }
}
