package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.Routine;
import com.qa.exerciseapp.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoutineController {

    private final RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) {this.routineService = routineService;}

    @GetMapping("/Routines")
    public List<Routine> getAllRoutines() {return this.routineService.readAllRoutines(); }

    @PostMapping("/createRoutine")
    public Routine createRoutine(@RequestBody Routine routine) {
        return this.routineService.createRoutine(routine);
    }

    @DeleteMapping("/deleteRoutine/{id}")
    public Boolean deleteRoutine(@PathVariable Long id) {
        return this.routineService.deleteRoutineById(id);
    }

    @GetMapping("/getRoutineById/{id}")
    public Routine getRoutineById(@PathVariable Long id) {
        return this.routineService.findRoutineById(id);
    }

    @PutMapping("/updateRoutine/{id}")
    public Routine updateRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        return this.routineService.updateRoutine(id, routine);
    }
}
