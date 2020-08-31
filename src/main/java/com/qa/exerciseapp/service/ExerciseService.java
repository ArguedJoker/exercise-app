package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.exceptions.ExerciseNotFoundException;
import com.qa.exerciseapp.repo.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository repo) {
        this.exerciseRepository = repo;
    }

    public List<ExerciseInfo> readAllExercises() {
        return this.exerciseRepository.findAll();
    }

    public ExerciseInfo createExercise(ExerciseInfo exercise) {
        return this.exerciseRepository.save(exercise);
    }

    public ExerciseInfo findExerciseById(Long id) {
        return this.exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
    }

    public ExerciseInfo updateExercise(Long id, ExerciseInfo exerciseInfo) {
        ExerciseInfo update = findExerciseById(id);
        update.setExerciseTitle(exerciseInfo.getExerciseTitle());
        update.setExerciseDescription(exerciseInfo.getExerciseDescription());
        update.setExerciseDuration(exerciseInfo.getExerciseDuration());
        update.setTargetMuscle(exerciseInfo.getTargetMuscle());
        update.setNumberOfSets(exerciseInfo.getNumberOfSets());
        update.setNumberOfReps(exerciseInfo.getNumberOfReps());
        return this.exerciseRepository.save(update);
    }

    public boolean deleteExerciseById(Long id) {
        if(!this.exerciseRepository.existsById(id)) {
            throw new ExerciseNotFoundException();
        }
        this.exerciseRepository.deleteById(id);
        return this.exerciseRepository.existsById(id);
    }
}
