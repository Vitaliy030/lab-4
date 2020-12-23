package com.springbootproject.mapper;

import com.springbootproject.dto.BaggageDTO;
import com.springbootproject.dto.TicketDTO;
import com.springbootproject.entity.Baggage;
import com.springbootproject.entity.Ticket;
import com.springbootproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        if(ticketDTO.getBaggages() == null) {
            ticket.setBaggages(null);
        } else {
            final List<Baggage> baggageList = new ArrayList<>();
            for (final BaggageDTO baggageDTO : ticketDTO.getBaggages()) {
                baggageList.add(baggageToBaggageDTOMapper.toEntity(baggageDTO, user));
            }
            ticket.setBaggages(baggageList);
        }

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

        if(ticket.getBaggages() == null) {
            ticketDTO.setBaggages(null);
        } else {
            final List<BaggageDTO> baggageDTOList = new ArrayList<>();
            for (final Baggage baggage : ticket.getBaggages()) {
                baggageDTOList.add(baggageToBaggageDTOMapper.toDTO(baggage));
            }
            ticketDTO.setBaggages(baggageDTOList);
        }

        ticketDTO.setPlaceOfDeparture(ticket.getPlaceOfDeparture());
        ticketDTO.setPlaceOfArrival(ticket.getPlaceOfArrival());
        ticketDTO.setSeat(ticket.getSeat());
        ticketDTO.setTakeoffTime(ticket.getTakeoffTime());
        ticketDTO.setBoardingTime(ticket.getBoardingTime());

        return ticketDTO;
    }
}
