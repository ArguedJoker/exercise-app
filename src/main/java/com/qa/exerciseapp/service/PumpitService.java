package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.Pumpit;
import com.qa.exerciseapp.repo.PumpitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PumpitService {

    private final PumpitRepository repo;

    @Autowired
    public PumpitService(PumpitRepository repo) {
        this.repo = repo;
    }

    public List<Pumpit> readAllActivities() {
        return this.repo.findAll();
    }

    public Pumpit createActivity(Pumpit activity) {
        return this.repo.save(activity);
    }

    public Pumpit fineActivityById(Long id) {
        return this.repo.findById(id).orElseThrow();
    }

}
