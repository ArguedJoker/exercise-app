package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.Pumpit;
import com.qa.exerciseapp.exceptions.ActivityNotFoundException;
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

    public Pumpit findActivityById(Long id) {
        return this.repo.findById(id).orElseThrow(ActivityNotFoundException::new);
    }

    public Pumpit updateActivity(Long id, Pumpit pumpit) {
        Pumpit update = findActivityById(id);
        update.setActivityTitle(pumpit.getActivityTitle());
        update.setActivityDescription(pumpit.getActivityDescription());
        update.setActivityDuration(pumpit.getActivityDuration());
        update.setNumberOfReps(pumpit.getNumberOfReps());
        return this.repo.save(update);
    }

    public boolean deleteActivityById(Long id) {
        if(!this.repo.existsById(id)) {
            throw new ActivityNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
