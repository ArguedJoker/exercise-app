package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

   private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/Exercises")
    public List<ExerciseInfo> getAllExercises() {
        return this.exerciseService.readAllExercises();
    }

    @PostMapping("/createExercise")
    public ExerciseInfo createExercise(@RequestBody ExerciseInfo exerciseInfo) {
        return this.exerciseService.createExercise(exerciseInfo);
    }

    @DeleteMapping("/deleteExercise/{id}")
    public Boolean deleteExercise(@PathVariable Long id) {
        return this.exerciseService.deleteExerciseById(id);
    }

    @GetMapping("/getExerciseById/{id}")
    public ExerciseInfo getExerciseById(@PathVariable Long id) {
        return this.exerciseService.findExerciseById(id);
    }

    @PutMapping("/updateExercise/{id}")
    public ExerciseInfo updateExercise(@PathVariable Long id, @RequestBody ExerciseInfo exercise) {
        return this.exerciseService.updateExercise(id, exercise);
    }
}
