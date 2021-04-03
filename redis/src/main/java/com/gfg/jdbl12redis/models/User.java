package com.gfg.jdbl12redis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {
    @Id
    private String id;
    private UserDetails  userDetails;
}
