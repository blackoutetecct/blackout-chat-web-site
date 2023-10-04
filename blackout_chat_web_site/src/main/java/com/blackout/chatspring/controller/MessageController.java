package com.blackout.chatspring.controller;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.model.MessageModel;
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

    @PostMapping("")
    public ResponseEntity<MessageModel> sendMessage(@RequestBody @Valid MessageDTO message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.save(message, false));
    }

    @PostMapping("/adm")
    public ResponseEntity<MessageModel> sendMessageAdm(@RequestBody @Valid MessageDTO message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.save(message, true));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteConversation(@RequestParam UUID session) {
        messageService.deleteConversation(session);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<List<MessageModel>> findConversation(@RequestParam UUID session) {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.listAllByConversation(session));
    }
}
