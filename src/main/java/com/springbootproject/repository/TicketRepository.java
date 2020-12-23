package com.springbootproject.repository;

import com.springbootproject.entity.Ticket;
import com.springbootproject.entity.User;
import com.springbootproject.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketRepository {

    @PostConstruct
    public void init() {
        savedTickets = new ArrayList<>();
    }

    private static Long lastId = 0L;
    private List<Ticket> savedTickets;

    @Autowired
    UserRepository userRepository;


    public Ticket getTicketById(final Long id) {
        return savedTickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Ticket with id: " + id + " not found "));
    }

    public List<Ticket> getAllTickets() {
        return savedTickets;
    }

    public Ticket createTicket(final Ticket ticket) {
        if (ticket.getId() != null) {
            throw new ServiceException(400, "Ticket shouldn't have an id ");
        }

        ++lastId;
        ticket.setId(lastId);
        savedTickets.add(ticket);
        return ticket;
    }

    public Ticket updateTicket(final Ticket ticket) {
        if (ticket.getId() == null) {
            throw new ServiceException(400, "Ticket should have an id ");
        }

        final Ticket savedTicket = getTicketById(ticket.getId());

        savedTicket.setFlight(ticket.getFlight());
        savedTicket.setPrice(ticket.getPrice());
        savedTicket.setUser(ticket.getUser());
        savedTicket.setBaggages(ticket.getBaggages());
        savedTicket.setPlaceOfDeparture(ticket.getPlaceOfDeparture());
        savedTicket.setPlaceOfArrival(ticket.getPlaceOfArrival());
        savedTicket.setSeat(ticket.getSeat());
        savedTicket.setTakeoffTime(ticket.getTakeoffTime());
        savedTicket.setBoardingTime(ticket.getBoardingTime());

        return savedTicket;
    }

    public void deleteTicketById(final Long id) {
        if(id == null) {
            throw new ServiceException(400, "Id isn't specified");
        }

        savedTickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Ticket with id: " + id + " not found "));

        savedTickets = savedTickets.stream()
                .filter(ticket -> !ticket.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsByUserId(final Long userId) {
        final User user = userRepository.getUserById(userId);
        return user.getTickets();
    }


    public Ticket setTicketById(final Long id, final Ticket ticket) {
        return  savedTickets.stream()
                .filter(tic -> tic.getId().equals(id))
                .findFirst()
                .map(tic -> tic = ticket)
                .orElseThrow(() -> new ServiceException(400, "Ticket with id: " + id + " not found "));
    }
}
