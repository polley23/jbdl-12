package com.gfg.jbdl12resfulwebservices.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BadRequest {
    private String message;
}
