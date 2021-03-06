package com.gfg.jbdl12urlshortener.resources;

import com.gfg.jbdl12urlshortener.manager.UrlShortenerManager;
import com.gfg.jbdl12urlshortener.model.UrlCreationRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private UrlShortenerManager urlShortenerManager;


    @PostMapping("/longUrl")
    @ApiResponse(message = "this is to create short url", code = 200)
    ResponseEntity createLongUrl(@RequestBody UrlCreationRequest urlCreationRequest){
        return ResponseEntity.ok(urlShortenerManager.createLongUrl(urlCreationRequest));
    }

    @GetMapping("/api/{encrypted_id}")
    ResponseEntity getLongUrl(@PathVariable("encrypted_id") String encryptedId){
        try {
            return ResponseEntity.ok(urlShortenerManager.getLongUrl(encryptedId));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("message");
        }
    }



}
