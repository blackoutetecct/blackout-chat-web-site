package com.blackout.chatspring.repository;

import com.blackout.chatspring.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<SessionModel, UUID> {

}
