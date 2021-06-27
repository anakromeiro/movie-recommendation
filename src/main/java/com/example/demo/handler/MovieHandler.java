package com.example.demo.handler;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {

    @Autowired
    private MovieService service;

    @Bean
    public RouterFunction<ServerResponse> route(MovieHandler movieHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/movies").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), movieHandler::allMovies)
                .andRoute(RequestPredicates.POST("/movie").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), movieHandler::addNewMovie);
    }

    public Mono<ServerResponse> allMovies(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.getAllMovies(), Movie.class);
    }

    public Mono<ServerResponse> addNewMovie(ServerRequest request) {
        Mono<String> movieName = request.bodyToMono(String.class);
        return movieName.flatMap(name ->
                ServerResponse.ok()
                        .build(service.addNewMovie(name).then()));
    }
}
