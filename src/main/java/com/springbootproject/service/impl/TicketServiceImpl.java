package com.springbootproject.service.impl;

import com.springbootproject.dto.TicketDTO;
import com.springbootproject.exception.ServiceException;
import com.springbootproject.mapper.TicketToTicketDTOMapper;
import com.springbootproject.repository.TicketRepository;
import com.springbootproject.repository.UserRepository;
import com.springbootproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketToTicketDTOMapper ticketMapper;

    @Autowired
    UserRepository userRepository;


    @Override
    public TicketDTO getTicketById(final Long id) {
        return ticketMapper.toDTO(ticketRepository.getTicketById(id));
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.getAllTickets().stream()
                .map(ticket -> ticketMapper.toDTO(ticket))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO createTicket(final TicketDTO ticketDTO, final Long userId) {
        if(ticketDTO.getId() != null) {
            throw new ServiceException(400, "Ticket shouldn't have an id ");
        }

        if(userId == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        return ticketMapper.toDTO(ticketRepository.createTicket(ticketMapper.toEntity(ticketDTO, userRepository.getUserById(userId))));
    }

    @Override
    public TicketDTO updateTicket(final TicketDTO ticketDTO, final Long userId) {
        if(ticketDTO.getId() == null) {
            throw new ServiceException(400, "Ticket should have an id ");
        }

        if(userId == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        return ticketMapper.toDTO(ticketRepository.updateTicket(ticketMapper.toEntity(ticketDTO, userRepository.getUserById(userId))));
    }

    @Override
    public void deleteTicketById(final Long id) {
        ticketRepository.deleteTicketById(id);
    }

    @Override
    public List<TicketDTO> getTicketsByUserId(final Long userId) {
        return ticketRepository.getTicketsByUserId(userId).stream()
                .map(ticket -> ticketMapper.toDTO(ticket))
                .collect(Collectors.toList());
    }
}
