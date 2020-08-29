package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.ExerciseInfo;
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

    public List<ExerciseInfo> readAllActivities() {
        return this.repo.findAll();
    }

    public ExerciseInfo createActivity(ExerciseInfo activity) {
        return this.repo.save(activity);
    }

    public ExerciseInfo findActivityById(Long id) {
        return this.repo.findById(id).orElseThrow(ActivityNotFoundException::new);
    }

    public ExerciseInfo updateActivity(Long id, ExerciseInfo exerciseInfo) {
        ExerciseInfo update = findActivityById(id);
        update.setActivityTitle(exerciseInfo.getActivityTitle());
        update.setActivityDescription(exerciseInfo.getActivityDescription());
        update.setActivityDuration(exerciseInfo.getActivityDuration());
        update.setNumberOfReps(exerciseInfo.getNumberOfReps());
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
