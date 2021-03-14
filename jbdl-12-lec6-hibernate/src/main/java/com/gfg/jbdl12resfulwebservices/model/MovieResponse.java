package com.gfg.jbdl12resfulwebservices.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
    private String movieName;
    private String genre;
    private String language;
    private List<CastResponse> castResponses;
    private List<AwardResponse> awardResponses;
    private RatingResponse ratingResponse;
}
