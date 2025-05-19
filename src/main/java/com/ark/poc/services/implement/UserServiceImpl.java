package com.ark.poc.services.implement;

import com.ark.poc.configs.properties.UserProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserProperties userProperties;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.equalsIgnoreCase(userProperties.getName())) {
            return new User(
                userProperties.getName(),
                userProperties.getPassword(),
                new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("User with username: " + username + "not found!");
        }
    }

}
