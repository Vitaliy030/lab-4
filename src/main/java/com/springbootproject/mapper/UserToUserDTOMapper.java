package com.springbootproject.mapper;

import com.springbootproject.dto.UserDTO;
import com.springbootproject.entity.Ticket;
import com.springbootproject.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO, final List<Ticket> ticketList) {
        final User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBirth(userDTO.getBirth());
        user.setTickets(ticketList);

        return user;
    }

    public UserDTO toDTO(final User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirth(user.getBirth());

        return userDTO;
    }
}
