package com.blackout.chatspring.mapper;

import com.blackout.chatspring.dto.UserDTO;
import com.blackout.chatspring.model.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public User toMapper(UserDTO objetoEntrada) {
        User objetoSaida = new User();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}
