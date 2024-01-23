package com.spring.security.config;

import com.spring.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    @Bean
    public UserDetailsService  userDetailsService(){
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
}
