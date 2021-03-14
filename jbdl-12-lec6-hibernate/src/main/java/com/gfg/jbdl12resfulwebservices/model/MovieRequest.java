package com.gfg.jbdl12resfulwebservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String movieName;
    private String genre;
    private String language;
    private List<CastRequest> castRequest;
    private List<AwardRequest> awardRequests;
    private RatingRequest ratingRequest;
}
