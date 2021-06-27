package com.example.demo.config;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
class DataInitializer implements ApplicationRunner {

    @Autowired
    private final MovieRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Start data initialization...");
        repository
                .saveAll(
                        List.of(
                                new Movie("Fight Club"),
                                new Movie("Black Swan")
                        )
                )
                .thenMany(
                        repository.findAll()
                )
                .subscribe((data) -> log.info("movie:" + data),
                        (err) -> log.error("error" + err),
                        () -> log.info("Done!")
                );
    }
}
