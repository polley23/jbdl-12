package com.gfg.jbdl12springsecurity.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/home")
    @PreAuthorize(value = "isAuthenticated()")
    public String home(){
       return "you are at home page";
    }

    @GetMapping("/secured")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String secured(){
        return "you are at secured page";
    }

}
