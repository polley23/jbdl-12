package com.gfg.jdbl12redis.manager;

import com.gfg.jdbl12redis.Repository.MySqlRepository;
import com.gfg.jdbl12redis.Repository.RedisRepository;
import com.gfg.jdbl12redis.models.MySqlUser;
import com.gfg.jdbl12redis.models.User;
import com.gfg.jdbl12redis.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private RedisRepository repository;

    @Autowired
    private MySqlRepository mySqlRepository;


    @Override
    public void create(UserDetails userDetails) {
        User user = User.builder()
                .id(userDetails.getUsername())
                .userDetails(userDetails)
                .build();
        repository.save(user);
        MySqlUser mySqlUser = MySqlUser
                .builder()
                .email(userDetails.getEmail())
                .name(userDetails.getName())
                .username(userDetails.getUsername())
                .build();
        mySqlRepository.save(mySqlUser);
    }

    @Override
    public UserDetails get(String username) throws Exception {
        User user =  repository.findById(username).orElseThrow(
                ()-> new Exception("username is  not found")
        );
        return user.getUserDetails();
    }

    @Override
    public UserDetails getFromMysql(String username) throws Exception {
        MySqlUser user =  mySqlRepository.findByUsername(username).orElseThrow(
                ()-> new Exception("username is  not found")
        );

        return UserDetails.builder()
                .email(user.getEmail())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
