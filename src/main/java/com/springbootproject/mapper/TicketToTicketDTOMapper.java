package com.springbootproject.mapper;

import com.springbootproject.dto.TicketDTO;
import com.springbootproject.entity.Baggage;
import com.springbootproject.entity.Ticket;
import com.springbootproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDTOMapper {

    @Autowired
    private BaggageToBaggageDTOMapper baggageToBaggageDTOMapper;

    public Ticket toEntity(final TicketDTO ticketDTO, final User user) {
        if(user == null) {

            //todo add custom exception throwing

        }

        final Ticket ticket = new Ticket();

        ticket.setId(ticketDTO.getId());
        ticket.setFlight(ticketDTO.getFlight());
        ticket.setPrice(ticketDTO.getPrice());
        ticket.setUser(user);
        ticket.setPlaceOfDeparture(ticketDTO.getPlaceOfDeparture());
        ticket.setPlaceOfArrival(ticketDTO.getPlaceOfArrival());
        ticket.setSeat(ticketDTO.getSeat());
        ticket.setTakeoffTime(ticketDTO.getTakeoffTime());
        ticket.setBoardingTime(ticketDTO.getBoardingTime());

        return ticket;
    }

    public TicketDTO toDTO(final Ticket ticket) {
        final TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setFlight(ticket.getFlight());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setUserFirstName(ticket.getUser().getFirstName());
        ticketDTO.setUserLastName(ticket.getUser().getLastName());

        for (final Baggage baggage : ticket.getBaggages()) {
            ticketDTO.getBaggages().add(baggageToBaggageDTOMapper.toDTO(baggage));
        }

        ticketDTO.setPlaceOfDeparture(ticket.getPlaceOfDeparture());
        ticketDTO.setPlaceOfArrival(ticket.getPlaceOfArrival());
        ticketDTO.setSeat(ticket.getSeat());
        ticketDTO.setTakeoffTime(ticket.getTakeoffTime());
        ticketDTO.setBoardingTime(ticket.getBoardingTime());

        return ticketDTO;
    }
}
