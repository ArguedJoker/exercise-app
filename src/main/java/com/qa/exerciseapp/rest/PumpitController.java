package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.Pumpit;
import com.qa.exerciseapp.service.PumpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PumpitController {

   private final PumpitService pumpitService;

    @Autowired
    public PumpitController(PumpitService pumpitService) {
        this.pumpitService = pumpitService;
    }

    @GetMapping("/Activities")
    public List<Pumpit> getAllActivities() {
        return this.pumpitService.readAllActivities();
    }

}
