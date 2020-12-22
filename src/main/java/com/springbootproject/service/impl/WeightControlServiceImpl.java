package com.springbootproject.service.impl;

import com.springbootproject.dto.BaggageDTO;
import com.springbootproject.dto.TicketDTO;
import com.springbootproject.exception.ServiceException;
import com.springbootproject.mapper.BaggageToBaggageDTOMapper;
import com.springbootproject.mapper.TicketToTicketDTOMapper;
import com.springbootproject.repository.BaggageRepository;
import com.springbootproject.repository.TicketRepository;
import com.springbootproject.service.WeightControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightControlServiceImpl implements WeightControlService {

    public static int MAX_WEIGHT = 23;


    @Autowired
    BaggageRepository baggageRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    BaggageToBaggageDTOMapper baggageMapper;

    @Autowired
    TicketToTicketDTOMapper ticketMapper;


    @Override
    public String getBaggageControlById(final Long baggageId) {
        if(baggageId == null) {
            throw new ServiceException(400, "Baggage should have an id ");
        }

        BaggageDTO baggageDTO = baggageMapper.toDTO(baggageRepository.getBaggageById(baggageId));

        if(baggageDTO.getWeight() > MAX_WEIGHT) {
            return "Baggage weight is more than the maximum!";
        } else {
            return "All OK";
        }
    }

    @Override
    public List<String> getAllBaggagesControlByTicketId(final Long ticketId) {
        if(ticketId == null) {
            throw new ServiceException(400, "Ticket should have an id ");
        }

        TicketDTO ticketDTO = ticketMapper.toDTO(ticketRepository.getTicketById(ticketId));
        List<String> results = new ArrayList<>();

        for (final BaggageDTO baggageDTO : ticketDTO.getBaggages()) {
            if(baggageDTO.getWeight() > MAX_WEIGHT) {
                results.add("ID: " + baggageDTO.getId() + ". Baggage weight is more than the maximum!");
            } else {
                results.add("ID: " + baggageDTO.getId() + ". All OK");
            }
        }
        return results;
    }
}
