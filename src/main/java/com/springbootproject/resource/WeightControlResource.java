package com.springbootproject.resource;

import com.springbootproject.service.WeightControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeightControlResource {

    @Autowired
    WeightControlService weightControlService;

    @GetMapping("/control/baggages/{id}")
    public String getBaggageControlById(final @PathVariable Long id) {
        return weightControlService.getBaggageControlById(id);
    }

    @GetMapping("/control/baggages")
    public List<String> getAllBaggagesControlByTicketId(final @PathVariable Long id) {
        return weightControlService.getAllBaggagesControlByTicketId(id);
    }
}
