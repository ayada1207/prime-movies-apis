package com.prime.movies.serviceimpl;

import com.prime.movies.Exception.MovieNotFoundException;
import com.prime.movies.common.ApiResponse;
import com.prime.movies.common.ResponseBuilder;
import com.prime.movies.model.Movies;
import com.prime.movies.repository.MovieRepository;
import com.prime.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private ResponseBuilder responseBuilder = new ResponseBuilder();

    @Override
    public ResponseEntity<ApiResponse> findAllMovies() {
        List<Movies> movies = movieRepository.findAll();
        return responseBuilder.buildResponse(HttpStatus.OK.value(),"List of movies",true,movies);
    }

    @Override
    public Optional<Movies> getMovie(String id) {
        return Optional.of(movieRepository.findMoviesByImdbId(id).
                orElseThrow(() -> new MovieNotFoundException(id)));
    }




}
