package com.elixrlbs.ChatApp.config;

import com.elixrlbs.ChatApp.constants.SecurityConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for application security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                        )
                .formLogin(form -> form
                        .loginPage(SecurityConstants.LOGIN_PAGE_URL)
                        .loginProcessingUrl(SecurityConstants.LOGIN_PROCESSING_URL)
                        .defaultSuccessUrl(SecurityConstants.DEFAULT_SUCCESS_URL,Boolean.TRUE)
                        .failureUrl(SecurityConstants.FAILURE_URL)
                        .permitAll()
                );
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
