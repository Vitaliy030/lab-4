package com.springbootproject.mapper;

import com.springbootproject.dto.BaggageDTO;
import com.springbootproject.entity.Baggage;
import com.springbootproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BaggageToBaggageDTOMapper {
    public Baggage toEntity(final BaggageDTO baggageDTO, final User user) {
        if(user == null) {

            //todo add custom exception throwing

        }

        final Baggage baggage = new Baggage();

        baggage.setId(baggageDTO.getId());
        baggage.setUser(user);
        baggage.setWeight(baggageDTO.getWeight());
        baggage.setSize(baggageDTO.getSize());

        return baggage;
    }

    public BaggageDTO toDTO(final Baggage baggage) {
        final BaggageDTO baggageDTO = new BaggageDTO();

        baggageDTO.setId(baggage.getId());
        baggageDTO.setUserFirstName(baggage.getUser().getFirstName());
        baggageDTO.setUserLastName(baggage.getUser().getLastName());
        baggageDTO.setWeight(baggage.getWeight());
        baggageDTO.setSize(baggage.getSize());

        return baggageDTO;
    }
}
