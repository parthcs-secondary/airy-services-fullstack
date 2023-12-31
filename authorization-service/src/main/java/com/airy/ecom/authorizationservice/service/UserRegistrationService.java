package com.airy.ecom.authorizationservice.service;


import com.airy.ecom.authorizationservice.dto.UserRequestDto;
import com.airy.ecom.authorizationservice.entity.User;
import com.airy.ecom.authorizationservice.repository.AuthorityRepository;
import com.airy.ecom.authorizationservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserRegistrationService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AuthorityRepository authorityRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRequestDto userRequestDto){

        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setEmailId(userRequestDto.getEmailId());
        user.setMobileNumber(userRequestDto.getMobileNumber());
        user.setCreationDate(LocalDateTime.now());
        user.setEnabled(true);
        user.setAuthorities(authorityRepository.findAll());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
