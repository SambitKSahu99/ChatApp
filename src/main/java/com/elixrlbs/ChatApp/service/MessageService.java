package com.elixrlbs.ChatApp.service;

import com.elixrlbs.ChatApp.constants.MessageConstants;
import com.elixrlbs.ChatApp.dto.MessageDto;
import com.elixrlbs.ChatApp.exceptionhandling.MessageException;
import com.elixrlbs.ChatApp.exceptionhandling.MessageNotFoundException;
import com.elixrlbs.ChatApp.model.MessageModel;
import com.elixrlbs.ChatApp.repository.MessageRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service class to store and retrieve messages
 */
@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MongoTemplate mongoTemplate;

    /**
     * Constructor injection of final fields
     * @param messageRepository MessageRepository object
     * @param mongoTemplate MongoTemplate object
     */
    public MessageService(MessageRepository messageRepository, MongoTemplate mongoTemplate) {
        this.messageRepository = messageRepository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Method to fetch message from user and store in the database with UUID
     * @param messageDto MessageDto object
     */
    public void saveMessage(MessageDto messageDto) throws MessageException {
        if (messageDto.getMessage().length()>MessageConstants.MAXIMUM_CHARACTER_LIMIT){
            throw new MessageException(MessageConstants.MAXIMUM_ALLOWED_CHARACTER_MESSAGE);
        }
        UUID uuid = UUID.randomUUID();
        MessageModel messageModel = new MessageModel();
        messageModel.setId(uuid);
        messageModel.setMessage(messageDto.getMessage());
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(MessageConstants.DATE_FORMAT);
        String formattedDate = simpleDateFormatter.format(Date.from(Instant.now()));
        messageModel.setTimeStamp(formattedDate);
        messageRepository.save(messageModel);
    }

    /**
     * Method to retrieve latest 10 messages from database and show user
     * @return List of MessageDto object
     */
    public List<MessageDto> retrieveMessages() throws MessageNotFoundException {
        Query query = new Query()
                .with(Sort.by(Sort.Order.desc(MessageConstants.TIME_STAMP)))
                .limit(MessageConstants.TEN_VALUE);
        List<MessageModel> messagesList = mongoTemplate.find(query,MessageModel.class);
        if (messagesList.isEmpty()){
            throw new MessageNotFoundException(MessageConstants.MESSAGES_NOT_FOUND);
        }
        return messagesList.stream()
                .map(messageModel -> {
                    MessageDto messageDto = new MessageDto();
                    messageDto.setMessage(messageModel.getMessage());
                    messageDto.setTimeStamp(messageModel.getTimeStamp());
                    return messageDto;
                })
                .collect(Collectors.toList());
    }
}
