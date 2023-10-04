package com.blackout.chatspring.mapper;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.model.MessageModel;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MessageMapper {
    public MessageModel toMapper(MessageDTO objetoEntrada, boolean isAdmin) {
        MessageModel objetoSaida = new MessageModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        objetoSaida.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        objetoSaida.setAdmin(isAdmin);

        return objetoSaida;
    }
}
