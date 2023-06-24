package com.prime.movies.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

public class MoviesDto {

    private ObjectId id;

    private String imdb;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private List<String> genres;

    private String poster;

    private List<String> backdrops;
    private List<String> reviewIds;
}
