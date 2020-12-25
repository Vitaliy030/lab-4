package com.springbootproject.repository;

import com.springbootproject.entity.Baggage;
import com.springbootproject.entity.Ticket;
import com.springbootproject.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BaggageRepository {

    @PostConstruct
    public void init() {
        savedBaggages = new ArrayList<>();
    }

    private static Long lastId = 0L;
    private List<Baggage> savedBaggages;

    @Autowired
    private TicketRepository ticketRepository;


    public Baggage getBaggageById(final Long id) {
        return savedBaggages.stream()
                .filter(baggage -> baggage.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Baggage with id: " + id + " not found "));
    }

    public List<Baggage> getAllBaggages() {
        return savedBaggages;
    }

    public Baggage createBaggage(final Baggage baggage, final Long ticketId) {
        if (baggage.getId() != null) {
            throw new ServiceException(400, "Baggage shouldn't have an id ");
        }

        ++lastId;
        baggage.setId(lastId);
        savedBaggages.add(baggage);

        final List<Baggage> baggageList = new ArrayList<>();
        if(ticketRepository.getTicketById(ticketId).getBaggages() == null) {
            baggageList.add(baggage);
        } else {
            baggageList.addAll(ticketRepository.getTicketById(ticketId).getBaggages());
            baggageList.add(baggage);
        }

        final Ticket ticket = ticketRepository.getTicketById(ticketId);
        ticket.setBaggages(baggageList);
        ticketRepository.setTicketById(ticketId, ticket);

        return baggage;
    }

    public Baggage updateBaggage(final Baggage baggage) {
        if (baggage.getId() == null) {
            throw new ServiceException(400, "Baggage should have an id ");
        }

        final Baggage savedBaggage = getBaggageById(baggage.getId());

        savedBaggage.setUser(baggage.getUser());
        savedBaggage.setWeight(baggage.getWeight());
        savedBaggage.setSize(baggage.getSize());

        return savedBaggage;
    }

    public void deleteBaggageById(final Long id) {
        if(id == null) {
            throw new ServiceException(400, "Id isn't specified");
        }

        savedBaggages.stream()
                .filter(baggage -> baggage.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Baggage with id: " + id + " not found "));

        savedBaggages = savedBaggages.stream()
                .filter(baggage -> !baggage.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Baggage> getBaggagesByTicketId(final Long userId) {
        final Ticket ticket = ticketRepository.getTicketById(userId);
        return ticket.getBaggages();
    }
}
