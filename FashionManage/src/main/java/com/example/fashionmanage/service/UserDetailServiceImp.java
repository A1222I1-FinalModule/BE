package com.example.fashionmanage.service;


import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> fUser = userRepository.findByUsername(username);
        return fUser.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));

    }

    public String findPasswordByUsername(String username) {
        return userRepository.findPasswordByUsername(username);
    }

    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }
}
