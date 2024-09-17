package com.elixrlbs.ChatApp.service;

import com.elixrlbs.ChatApp.model.AuthUser;
import com.elixrlbs.ChatApp.repository.AuthUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Auth User service class extending UserDetailsService to handled user identity
 */
@Service
public class AuthUserService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public AuthUserService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    /**
     * Method to match user entered username and password with existing username and password in database
     * @param username Username enter for login
     * @return UserDetails object
     * @throws UsernameNotFoundException exception object if user doesn't exists
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> user = authUserRepository.findByUserName(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException(username);
        }else{
            return User.builder()
                    .username(user.get().getUserName())
                    .password(user.get().getPassword())
                    .disabled(!user.get().isActive())
                    .build();
        }
    }
}
