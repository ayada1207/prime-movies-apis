package com.prime.movies.service;

import com.prime.movies.common.ApiResponse;
import com.prime.movies.model.Movies;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MovieService {
     ResponseEntity<ApiResponse> findAllMovies();

     Optional<Movies> getMovie(String imdbId);
}
