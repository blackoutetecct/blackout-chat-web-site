package com.blackout.chatspring.service;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.exception.ExceptionGeneric;
import com.blackout.chatspring.mapper.MessageMapper;
import com.blackout.chatspring.model.MessageModel;
import com.blackout.chatspring.model.SessionModel;
import com.blackout.chatspring.repository.MessageRepository;
import com.blackout.chatspring.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    @Transactional
    public SessionModel save() {
        return sessionRepository.save(SessionModel.builder().build());
    }

    @Transactional
    public void deleteSession(UUID session) {
        sessionRepository.deleteById(session);
    }

    public List<SessionModel> listConversations() {
        return sessionRepository.findAll();
    }
}