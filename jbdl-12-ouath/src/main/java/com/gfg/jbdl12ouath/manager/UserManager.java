package com.gfg.jbdl12ouath.manager;

import com.gfg.jbdl12ouath.models.UserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserManager extends UserDetailsService {
    public void signUp(UserRequest userRequest) throws Exception;
}
