package com.springbootproject.service;

import com.springbootproject.dto.BaggageDTO;

import java.util.List;

public interface BaggageService {
    BaggageDTO getBaggageById(Long id);
    List<BaggageDTO> getAllBaggages();
    BaggageDTO createBaggage(BaggageDTO baggageDTO, Long userId);
    BaggageDTO updateBaggage(BaggageDTO baggageDTO, Long userId);
    void deleteBaggageById(Long id);
    List<BaggageDTO> getBaggagesByTicketId(final Long ticketId);
}
