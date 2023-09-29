package com.blackout.chatspring.service;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.exception.ExceptionGeneric;
import com.blackout.chatspring.mapper.MessageMapper;
import com.blackout.chatspring.model.MessageModel;
import com.blackout.chatspring.repository.MessageRepository;
import com.blackout.chatspring.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final SessionRepository sessionRepository;

    @Transactional
    public MessageModel save(MessageDTO message) {
        verifySession(message.getSession());
        return messageRepository.save(
                new MessageMapper().toMapper(message)
        );
    }

    @Transactional
    public void deleteConversation(UUID session) {
        messageRepository.deleteAllBySession(session);
        sessionRepository.deleteById(session);
    }

    public List<MessageModel> listAllByConversation(UUID session) {
        return messageRepository.findAllBySession(session).orElseThrow(
                () -> new ExceptionGeneric("SESSION NOT FOUND", "THE SESSION INFORMATED NOT EXISTS", 400)
        );
    }

    private void verifySession(UUID session) {
        if(!sessionRepository.existsById(session))
            throw new ExceptionGeneric("SESSION NOT FOUND", "THE SESSION INFORMATED NOT EXISTS", 400);
    }
}