package com.springbootproject.service.impl;

import com.springbootproject.dto.BaggageDTO;
import com.springbootproject.exception.ServiceException;
import com.springbootproject.mapper.BaggageToBaggageDTOMapper;
import com.springbootproject.repository.BaggageRepository;
import com.springbootproject.repository.UserRepository;
import com.springbootproject.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaggageServiceImpl implements BaggageService {

    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private BaggageToBaggageDTOMapper baggageMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public BaggageDTO getBaggageById(final Long id) {
        return baggageMapper.toDTO(baggageRepository.getBaggageById(id));
    }

    @Override
    public List<BaggageDTO> getAllBaggages() {
        return baggageRepository.getAllBaggages().stream()
                .map(baggage -> baggageMapper.toDTO(baggage))
                .collect(Collectors.toList());
    }

    @Override
    public BaggageDTO createBaggage(final BaggageDTO baggageDTO, final Long userId) {
        if(baggageDTO.getId() != null) {
            throw new ServiceException(400, "Baggage shouldn't have an id ");
        }

        if(userId == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        return baggageMapper.toDTO(baggageRepository.createBaggage(baggageMapper.toEntity(baggageDTO, userRepository.getUserById(userId))));
    }

    @Override
    public BaggageDTO updateBaggage(final BaggageDTO baggageDTO, final Long userId) {
        if(baggageDTO.getId() == null) {
            throw new ServiceException(400, "Baggage should have an id ");
        }

        if(userId == null) {
            throw new ServiceException(400, "User should have an id ");
        }

        return baggageMapper.toDTO(baggageRepository.updateBaggage(baggageMapper.toEntity(baggageDTO, userRepository.getUserById(userId))));
    }

    @Override
    public void deleteBaggageById(final Long id) {
        baggageRepository.deleteBaggageById(id);
    }

    @Override
    public List<BaggageDTO> getBaggagesByTicketId(final Long ticketId) {
        return baggageRepository.getBaggagesByTicketId(ticketId).stream()
                .map(baggage -> baggageMapper.toDTO(baggage))
                .collect(Collectors.toList());
    }
}
