package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /*@PostMapping("/createActivity")
    public ExerciseInfo createActivity(ExerciseInfo exerciseInfo) {
        return this.pumpitService.createActivity()
    }
*/
}
