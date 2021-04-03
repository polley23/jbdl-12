package com.gfg.jdbl12redis.manager;


import com.gfg.jdbl12redis.models.UserDetails;

public interface UserManager {
    void create(UserDetails userDetails);
    UserDetails get(String username) throws Exception;
    UserDetails getFromMysql(String username) throws Exception;
}
