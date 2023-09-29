package com.blackout.chatspring.controller;

import com.blackout.chatspring.model.SessionModel;
import com.blackout.chatspring.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @GetMapping("")
    public ResponseEntity<SessionModel> startConversation() {
        return ResponseEntity.status(HttpStatus.OK).body(sessionService.save());
    }

    @GetMapping("/all")
    public ResponseEntity<List<SessionModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sessionService.listConversations());
    }
}
