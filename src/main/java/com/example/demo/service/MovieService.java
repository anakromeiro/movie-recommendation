package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Flux<Movie> getAllMovies(){
        return repository.findAll();
    }

    public Mono<Movie> addNewMovie(String name) {
        Movie movie = new Movie(name);
        return repository.save(movie);
    }
}
