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

    /**
     *  Check user has username . If exists return it else return NotFoundException
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     * @author AiPV
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> fUser = userRepository.findByUsername(username);
        return fUser.orElseThrow(()-> new UsernameNotFoundException("Invalid credentials"));

    }
}
