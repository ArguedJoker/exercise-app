package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.exceptions.ActivityNotFoundException;
import com.qa.exerciseapp.repo.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository repo;

    @Autowired
    public ExerciseService(ExerciseRepository repo) {
        this.repo = repo;
    }

    public List<ExerciseInfo> readAllExercises() {
        return this.repo.findAll();
    }

    public ExerciseInfo createExercise(ExerciseInfo activity) {
        return this.repo.save(activity);
    }

    public ExerciseInfo findExerciseById(Long id) { return this.repo.findById(id).orElseThrow(ActivityNotFoundException::new); }

    public ExerciseInfo updateExercise(Long id, ExerciseInfo exerciseInfo) {
        ExerciseInfo update = findExerciseById(id);
        update.setExerciseTitle(exerciseInfo.getExerciseTitle());
        update.setExerciseDescription(exerciseInfo.getExerciseDescription());
        update.setExerciseDuration(exerciseInfo.getExerciseDuration());
        update.setTargetMuscle(exerciseInfo.getTargetMuscle());
        update.setNumberOfSets(exerciseInfo.getNumberOfSets());
        update.setNumberOfReps(exerciseInfo.getNumberOfReps());
        return this.repo.save(update);
    }

    public boolean deleteExerciseById(Long id) {
        if(!this.repo.existsById(id)) {
            throw new ActivityNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
