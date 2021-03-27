package com.gfg.jbdl12ouath.resource;

import com.gfg.jbdl12ouath.manager.UserManager;
import com.gfg.jbdl12ouath.models.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserManager userManager;

    @GetMapping("/home")
    @PreAuthorize(value = "hasAnyRole('admin','user')")
    public String home(){
       return "you are at home page";
    }

    @GetMapping("/secured")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String secured(){
        return "you are at secured page";
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserRequest userRequest){
        try {
            userManager.signUp(userRequest);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }


}
