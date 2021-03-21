package com.gfg.jbdl12springsecurityuserdetailsservice.manager;

import com.gfg.jbdl12springsecurityuserdetailsservice.models.Roles;
import com.gfg.jbdl12springsecurityuserdetailsservice.models.User;
import com.gfg.jbdl12springsecurityuserdetailsservice.models.UserRequest;
import com.gfg.jbdl12springsecurityuserdetailsservice.repository.RoleRepository;
import com.gfg.jbdl12springsecurityuserdetailsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepository
                 .findByUsername(username)
                 .orElseThrow(()->new UsernameNotFoundException("username is not found"));
    }

    @Override
    public void signUp(UserRequest userRequest) throws Exception {
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new Exception("user is present");
        }
        Optional<Roles> rolesOptional = roleRepository.findByRole("user");
        Roles roles = null;
        if(!rolesOptional.isPresent()){
            roles= Roles.builder().role("user").build();
        }else{
            roles = rolesOptional.get();
        }
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(Arrays.asList(roles))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        userRepository.save(user);
    }
}
