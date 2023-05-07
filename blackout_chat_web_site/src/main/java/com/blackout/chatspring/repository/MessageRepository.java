package com.blackout.chatspring.repository;

import com.blackout.chatspring.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    List<Message> findAllBySender(UUID sender);
    void deleteAllBySender(UUID sender);
}
