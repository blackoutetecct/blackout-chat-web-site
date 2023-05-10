package com.blackout.chatspring.service;

import com.blackout.chatspring.dto.UserDTO;
import com.blackout.chatspring.exception.ExceptionGeneric;
import com.blackout.chatspring.mapper.UserMapper;
import com.blackout.chatspring.model.User;
import com.blackout.chatspring.repository.MessageRepository;
import com.blackout.chatspring.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Transactional
    public User save(UserDTO userDTO) {
        return userRepository.save(
                setTime(new UserMapper().toMapper(userDTO))
        );
    }

    @Transactional
    public void deleteFull(UUID user) {
        messageRepository.deleteAllBySender(user);
        userRepository.deleteById(user);
    }

    public void isAdmin(UUID id) {
        var user = findById(id);
        user.setAdmin(true);
        userRepository.save(user);
    }

    public void endChat(UUID id) {
        var user = findById(id);
        user.setChatEnded(true);
        userRepository.save(user);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findById(UUID id){
        return userRepository.findById(id).orElseThrow(
                () -> new ExceptionGeneric("Usuário", "Usuário não encontrado.", HttpStatus.NO_CONTENT.value())
        );
    }

    private User setTime(User user) {
        user.setDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return user;
    }
}
