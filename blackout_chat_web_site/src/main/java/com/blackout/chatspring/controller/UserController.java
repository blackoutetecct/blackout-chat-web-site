package com.blackout.chatspring.controller;

import com.blackout.chatspring.dto.UserDTO;
import com.blackout.chatspring.model.User;
import com.blackout.chatspring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody @Valid UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/admin")
    public ResponseEntity<Void> isAdmin(@RequestParam UUID id) {
        userService.isAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Void> endChat(@RequestParam UUID id) {
        userService.endChat(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID userId) {
        userService.deleteFull(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }

    @GetMapping("")
    public ResponseEntity<User> findById(@RequestParam UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }
}
