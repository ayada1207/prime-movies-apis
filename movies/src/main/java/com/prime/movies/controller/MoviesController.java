package com.prime.movies.controller;

import com.prime.movies.dto.MoviesDto;
import com.prime.movies.model.Movies;
import com.prime.movies.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api/v1/prime"}, produces = APPLICATION_JSON_VALUE)
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/movies")
    @Operation(summary = "fetch list of prime movies")
    @ApiResponse(responseCode = "201", description = "movies fetched",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MoviesDto.class))})
    public ResponseEntity<com.prime.movies.common.ApiResponse> fetchMoviesList() {
        return movieService.findAllMovies();
    }

    @GetMapping(path = "/movies/{id}")
    @Operation(summary = "fetch  movie based on imdbId")
    @ApiResponse(responseCode = "201", description = "movies fetched",
            content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MoviesDto.class))})
    @ApiResponse(responseCode = "500", description = "No movie found with given Id",
            content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MoviesDto.class))})
    public ResponseEntity<Optional<Movies>> movie(@PathVariable String id) {
        return new ResponseEntity<Optional<Movies>>(movieService.getMovie(id),HttpStatus.OK);
    }
}
