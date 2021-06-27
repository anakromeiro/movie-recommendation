package com.example.demo.webclient;

import com.example.demo.model.Movie;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MovieWebClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public Mono<Movie> getAll() {
        return client.get()
                .uri("/movies")
//                .headers(headers -> headers.setBasicAuth("user", "userpwd"))
                .retrieve()
                .bodyToMono(Movie.class);
    }
}
