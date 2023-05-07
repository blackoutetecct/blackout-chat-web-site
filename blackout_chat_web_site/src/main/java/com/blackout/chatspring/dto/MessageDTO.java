package com.blackout.chatspring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class MessageDTO {
    @NotEmpty @NotNull
    private String text;

    @NotNull
    private UUID sender;

    @NotNull
    private boolean isReponse;
}
