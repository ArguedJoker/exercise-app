package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.Routine;
import com.qa.exerciseapp.exceptions.ExerciseNotFoundException;
import com.qa.exerciseapp.exceptions.RoutineNotFoundException;
import com.qa.exerciseapp.repo.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    @Autowired
    public RoutineService(RoutineRepository repo) { this.routineRepository = repo; }

    public List<Routine> readAllRoutines() {
        return this.routineRepository.findAll();
    }

    public Routine createRoutine(Routine routine) {
        return this.routineRepository.save(routine);
    }

    public Routine findRoutineById(Long id) {
        return this.routineRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
    }

    public Routine updateRoutine(Long id, Routine routine) {
        Routine update = findRoutineById(id);
        update.setRoutineName(routine.getRoutineName());
        update.setUserId(routine.getUserId());
        update.setExerciseInfoId(routine.getExerciseInfoId());
        return this.routineRepository.save(update);
    }

    public boolean deleteRoutineById(Long id) {
        if(!this.routineRepository.existsById(id)) {
            throw new RoutineNotFoundException();
        }
        this.routineRepository.deleteById(id);
        return this.routineRepository.existsById(id);
    }


}
