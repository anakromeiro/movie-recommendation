package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@RequiredArgsConstructor
@Getter
@Data
@Table
public class Movie {

    @Id
    private Integer id;
    private final String name;
}
