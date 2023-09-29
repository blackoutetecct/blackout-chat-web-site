package com.blackout.chatspring.repository;

import com.blackout.chatspring.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, UUID> {
    Optional<List<MessageModel>> findAllBySession(UUID session);
    void deleteAllBySession(UUID session);
}
