package com.blackout.chatspring.mapper;

import com.blackout.chatspring.dto.MessageDTO;
import com.blackout.chatspring.model.Message;
import org.springframework.beans.BeanUtils;

public class MessageMapper {
    public Message toMapper(MessageDTO objetoEntrada) {
        Message objetoSaida = new Message();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
