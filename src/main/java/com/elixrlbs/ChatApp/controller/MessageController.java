package com.elixrlbs.ChatApp.controller;

import com.elixrlbs.ChatApp.constants.ApiEndpointsConstants;
import com.elixrlbs.ChatApp.constants.MessageConstants;
import com.elixrlbs.ChatApp.dto.MessageDto;
import com.elixrlbs.ChatApp.exceptionhandling.MessageException;
import com.elixrlbs.ChatApp.exceptionhandling.MessageNotFoundException;
import com.elixrlbs.ChatApp.response.SuccessResponse;
import com.elixrlbs.ChatApp.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the Controller class which will have all API endpoints
 */
@RestController
@CrossOrigin(origins = MessageConstants.ALLOWED_ORIGINS)
public class MessageController {

    private final MessageService messageService;

    /**
     * Constructor injection for final fields
     * @param messageService MessageService object
     */
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Post method to save message in the database
     * @param messageDto MessageDto object containing the message
     * @return ResponseEntity object
     */
    @PostMapping(ApiEndpointsConstants.MESSAGE_ENDPOINT)
    public ResponseEntity<SuccessResponse> saveMessage(@RequestBody MessageDto messageDto) throws MessageException {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage(MessageConstants.MESSAGE_INSERTION_SUCCESSFUL);
        messageService.saveMessage(messageDto);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    /**
     * Get method to send messages to user
     * @return Response Entity object
     */
    @GetMapping(ApiEndpointsConstants.MESSAGE_ENDPOINT)
    public ResponseEntity<List<MessageDto>> retrieveMessage() throws MessageNotFoundException {
        List<MessageDto> messagesList = messageService.retrieveMessages();
        return new ResponseEntity<>(messagesList, HttpStatus.OK);
    }
}
