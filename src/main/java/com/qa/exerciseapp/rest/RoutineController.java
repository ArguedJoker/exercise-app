package com.qa.exerciseapp.rest;

import com.qa.exerciseapp.domain.Routine;
import com.qa.exerciseapp.dto.RoutineDTO;
import com.qa.exerciseapp.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoutineController {

    private final RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) { this.routineService = routineService; }

    @GetMapping("/Routines")
    public ResponseEntity<List<RoutineDTO>> getAllRoutines() {
        return ResponseEntity.ok(this.routineService.readAllRoutines());
    }

    @PostMapping("/createRoutine")
    public ResponseEntity<RoutineDTO> createRoutine(@RequestBody Routine routine) {
        return new ResponseEntity<>(this.routineService.createRoutine(routine), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRoutine/{id}")
    public ResponseEntity<?> deleteRoutine(@PathVariable Long id) {
        return this.routineService.deleteRoutineById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getRoutineById/{id}")
    public ResponseEntity<RoutineDTO> getRoutineById(@PathVariable Long id) {
        return ResponseEntity.ok(this.routineService.findRoutineById(id));
    }

    @PutMapping("/updateRoutine/{id}")
    public ResponseEntity<RoutineDTO> updateRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        return ResponseEntity.ok(this.routineService.updateRoutine(id, routine));
    }
}
