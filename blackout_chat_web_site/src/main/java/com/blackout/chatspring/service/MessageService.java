package com.blackout.chatspring.service;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.exception.ExceptionGeneric;
import com.blackout.chatspring.mapper.MessageMapper;
import com.blackout.chatspring.model.Message;
import com.blackout.chatspring.model.User;
import com.blackout.chatspring.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    @Transactional
    public Message save(MessageDTO messageDTO) {
        return messageRepository.save(
                setTime(new MessageMapper().toMapper(messageDTO))
        );
    }

    public List<Message> listAll(){
        return messageRepository.findAll();
    }

    public List<Message> listAllByRoom(UUID sender) {
        return messageRepository.findAllBySender(sender);
    }

    public Message findById(UUID id){
        return messageRepository.findById(id).orElseThrow(() -> new ExceptionGeneric("Mensagem", "Mensagem não encontrada.", HttpStatus.NO_CONTENT.value()));
    }

    private Message setTime(Message message) {
        message.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return message;
    }
}