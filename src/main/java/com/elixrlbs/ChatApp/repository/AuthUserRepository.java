package com.elixrlbs.ChatApp.repository;

import com.elixrlbs.ChatApp.model.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Auth User repository to fetch username and password
 */
@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, UUID> {
    Optional<AuthUser> findByUserName(String userName);
}
