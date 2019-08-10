package com.gihan.jwtspringtest.services;

import com.gihan.jwtspringtest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class JwtUserDetailsService implements UserDetailsService {


    private List<User> userDao = new ArrayList<>();

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Cacheable(cacheNames="USER_CACHE",key="#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        boolean isUserFound = false;
        for (User user : userDao) {
            if(user.getUsername().equals(username)){
                isUserFound = true;
                User returnUser = user;
                return returnUser;

            }
        }

        if(!isUserFound){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return null;
    }

    public UserDTO save(UserDTO user) {
        String encodedPass = bcryptEncoder.encode(user.getPassword());
        User newUser = new User(user.getUsername(),encodedPass,new ArrayList<>());
        userDao.add(newUser);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

}
