package com.springbootproject.service;

import com.springbootproject.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO getTicketById(Long id);
    List<TicketDTO> getAllTickets();
    TicketDTO createTicket(TicketDTO ticketDTO, Long userId);
    TicketDTO updateTicket(TicketDTO ticketDTO, Long userId);
    void deleteTicketById(Long id);
    List<TicketDTO> getTicketsByUserId(final Long userId);
}
