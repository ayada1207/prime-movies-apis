package com.prime.movies.repository;

import com.prime.movies.model.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movies, ObjectId> {

     List<Movies> findAll();

     Optional<Movies> findMoviesByImdbId(String imdbId);
}
