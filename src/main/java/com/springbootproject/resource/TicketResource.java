package com.springbootproject.resource;

import com.springbootproject.dto.TicketDTO;
import com.springbootproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TicketResource {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/tickets/{id}")
    public TicketDTO getTicketById(final @PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/tickets")
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/users/{id}")
    public List<TicketDTO> getTicketsByUserId(final @PathVariable Long id) {
        return ticketService.getTicketsByUserId(id);
    }

    @PostMapping("/users/{id}/tickets")
    public TicketDTO createTicket(final @Valid @RequestBody TicketDTO ticketDTO,
                                  final @PathVariable Long id) {
        return ticketService.createTicket(ticketDTO, id);
    }

    @PutMapping("/users/{id}/tickets")
    public TicketDTO updateTicket(final @Valid @RequestBody TicketDTO ticketDTO,
                                  final @PathVariable Long id){
        return ticketService.updateTicket(ticketDTO, id);
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicketById(final @PathVariable Long id){
        ticketService.deleteTicketById(id);
    }
}
