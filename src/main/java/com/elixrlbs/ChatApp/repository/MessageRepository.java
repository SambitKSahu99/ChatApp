package com.elixrlbs.ChatApp.repository;

import com.elixrlbs.ChatApp.model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Repository Interface to interact with the database
 */
public interface MessageRepository extends MongoRepository<MessageModel, UUID> {
}
