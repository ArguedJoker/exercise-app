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

    @GetMapping("/Activities")
    public List<ExerciseInfo> getAllActivities() {
        return this.exerciseService.readAllActivities();
    }

    @PostMapping("/createActivities")
    public ExerciseInfo createActivity(@RequestBody ExerciseInfo exerciseInfo) {
        return this.exerciseService.createActivity(exerciseInfo);
    }

    @DeleteMapping("/deleteActivity/{id}")
    public Boolean deleteActivity(@PathVariable Long id) {
        return this.exerciseService.deleteActivityById(id);
    }

    @GetMapping("/getActivityById/{id}")
    public ExerciseInfo getExerciseById(@PathVariable Long id) {
        return this.exerciseService.findActivityById(id);
    }
}
