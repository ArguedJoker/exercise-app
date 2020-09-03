package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.Routine;
import com.qa.exerciseapp.dto.RoutineDTO;
import com.qa.exerciseapp.exceptions.RoutineNotFoundException;
import com.qa.exerciseapp.repo.RoutineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final ModelMapper mapper;

    @Autowired
    public RoutineService(RoutineRepository repo, ModelMapper mapper) {
        this.routineRepository = repo;
        this.mapper = mapper;
    }

    private RoutineDTO mapToDTO(Routine routine) {
        return this.mapper.map(routine, RoutineDTO.class);
    }

    public List<RoutineDTO> readAllRoutines() {

        return this.routineRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RoutineDTO createRoutine(Routine routine) {
        return this.mapToDTO(this.routineRepository.save(routine));
    }

    public RoutineDTO findRoutineById(Long id) {
        return this.mapToDTO(this.routineRepository.findById(id).orElseThrow(RoutineNotFoundException::new));
    }

    public RoutineDTO updateRoutine(Long id, Routine routine) {
        Routine update = this.routineRepository.findById(id).orElseThrow(RoutineNotFoundException::new);
        update.setRoutineName(routine.getRoutineName());
        return this.mapToDTO(this.routineRepository.save(update));
    }

    public Boolean deleteRoutineById(Long id) {
        if(!this.routineRepository.existsById(id)) {
            throw new RoutineNotFoundException();
        }
        this.routineRepository.deleteById(id);
        return this.routineRepository.existsById(id);
    }


}
