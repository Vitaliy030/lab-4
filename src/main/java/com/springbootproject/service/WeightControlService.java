package com.springbootproject.service;

import java.util.List;

public interface WeightControlService {
    String getBaggageControlById(Long baggageId);
    List<String> getAllBaggagesControlByTicketId(Long ticketId);
}
