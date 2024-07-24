package com.learning.spring_learning_oauth.services;

import com.learning.spring_learning_oauth.entities.User;
import com.learning.spring_learning_oauth.models.others.CustomUserDetails;
import com.learning.spring_learning_oauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    };

    public User createUser(User user) {
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}