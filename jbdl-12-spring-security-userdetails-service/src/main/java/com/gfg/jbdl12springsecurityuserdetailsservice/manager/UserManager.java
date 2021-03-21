package com.gfg.jbdl12springsecurityuserdetailsservice.manager;

import com.gfg.jbdl12springsecurityuserdetailsservice.models.UserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserManager extends UserDetailsService {
    public void signUp(UserRequest userRequest) throws Exception;
}
