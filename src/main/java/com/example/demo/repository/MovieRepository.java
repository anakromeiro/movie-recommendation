package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovieRepository extends ReactiveCrudRepository<Movie, Integer> {}
