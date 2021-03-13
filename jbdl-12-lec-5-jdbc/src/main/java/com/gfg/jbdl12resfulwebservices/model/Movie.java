package com.gfg.jbdl12resfulwebservices.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Movie {
    private String movieName;
    private String genre;
    private String language;
}
