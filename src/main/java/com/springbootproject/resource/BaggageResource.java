package com.springbootproject.resource;

import com.springbootproject.dto.BaggageDTO;
import com.springbootproject.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaggageResource {

    @Autowired
    private BaggageService baggageService;


    @GetMapping("/baggages/{id}")
    public BaggageDTO getBaggageById(final @PathVariable Long id) {
        return baggageService.getBaggageById(id);
    }

    @GetMapping("/baggages")
    public List<BaggageDTO> getAllBaggages() {
        return baggageService.getAllBaggages();
    }

    @GetMapping("/baggages/tickets/{id}")
    public List<BaggageDTO> getBaggagesByTicketId(final @PathVariable Long id) {
        return baggageService.getBaggagesByTicketId(id);
    }

    @PostMapping("/users/{userId}/tickets/{ticketId}/baggages")
    public BaggageDTO createBaggage(final @RequestBody BaggageDTO baggageDTO,
                                    final @PathVariable Long userId,
                                    final @PathVariable Long ticketId) {
        return baggageService.createBaggage(baggageDTO, userId, ticketId);
    }

    @PutMapping("/users/{id}/baggages")
    public BaggageDTO updateBaggage(final @RequestBody BaggageDTO baggageDTO,
                                    final @PathVariable Long id){
        return baggageService.updateBaggage(baggageDTO, id);
    }

    @DeleteMapping("/baggages/{id}")
    public void deleteBaggageById(final @PathVariable Long id){
        baggageService.deleteBaggageById(id);
    }
}
