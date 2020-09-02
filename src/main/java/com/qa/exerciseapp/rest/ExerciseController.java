package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.dto.ExerciseInfoDTO;
import com.qa.exerciseapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ExerciseInfoDTO>> getAllExercises() {
        return ResponseEntity.ok(this.exerciseService.readAllExercises());
    }

    @PostMapping("/createExercise")
    public ResponseEntity<ExerciseInfoDTO> createExercise(@RequestBody ExerciseInfo exerciseInfo) {
        return new ResponseEntity<ExerciseInfoDTO>(this.exerciseService.createExercise(exerciseInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteExercise/{id}")
    public Boolean deleteExercise(@PathVariable Long id) {
        return this.exerciseService.deleteExerciseById(id);
    }

    @GetMapping("/getExerciseById/{id}")
    public ResponseEntity<ExerciseInfoDTO> getExerciseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.exerciseService.findExerciseById(id));
    }

    @PutMapping("/updateExercise/{id}")
    public ResponseEntity<ExerciseInfoDTO> updateExercise(@PathVariable Long id, @RequestBody ExerciseInfo exercise) {
        return ResponseEntity.ok(this.exerciseService.updateExercise(id, exercise));
    }
}
