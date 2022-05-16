package com.shaliya.springemaildemo.controller;

import com.shaliya.springemaildemo.service.EmailSenderService;
import com.shaliya.springemaildemo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/send-email")
public class EmailSenderController {
    private final Logger LOGGER = LoggerFactory.getLogger(EmailSenderController.class);

    @Autowired
    private EmailSenderService senderService;

    @PostMapping( params = {"email"})
    public ResponseEntity<StandardResponse> sendEmail(@RequestParam(value = "email") String  email ) throws MessagingException {
        boolean success = senderService.sendEmail(email);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, success + " success added", success),
                HttpStatus.CREATED);
    }

}
