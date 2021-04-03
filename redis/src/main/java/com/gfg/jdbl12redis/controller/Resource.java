package com.gfg.jdbl12redis.controller;

import com.gfg.jdbl12redis.manager.UserManager;
import com.gfg.jdbl12redis.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Resource {

    @Autowired
    private UserManager userManager;

    @PostMapping("/user")
    void create(@RequestBody UserDetails userDetails){
        userManager.create(userDetails);
    }

    @GetMapping("/user/{username}")
    ResponseEntity get(@PathVariable("username") String username) throws Exception {
        return ResponseEntity.ok(userManager.get(username));
    }

    @GetMapping("/user/mysql/{username}")
    ResponseEntity getMysql(@PathVariable("username") String username) throws Exception {
        return ResponseEntity.ok(userManager.getFromMysql(username));
    }
}
