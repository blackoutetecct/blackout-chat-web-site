package com.blackout.chatspring.controller;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.model.Message;
import com.blackout.chatspring.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> send(@RequestParam UUID response, @RequestBody @Valid MessageDTO message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.save(response, message));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteMessageBySender(@RequestParam UUID userId) {
        messageService.deleteFull(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.listAll());
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> findAllByUser(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.listAllByRoom(id));
    }

    @GetMapping("")
    public ResponseEntity<Message> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findById(id));
    }
}
