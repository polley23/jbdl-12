package com.gfg.jdbl12redis.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetails {
    private String username;
    private String name;
    private String email;
}
