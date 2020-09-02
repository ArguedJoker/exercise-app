package com.qa.exerciseapp.service;

import com.qa.exerciseapp.domain.ExerciseInfo;
import com.qa.exerciseapp.dto.ExerciseInfoDTO;
import com.qa.exerciseapp.exceptions.ExerciseNotFoundException;
import com.qa.exerciseapp.repo.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final ModelMapper mapper;

    @Autowired
    public ExerciseService(ExerciseRepository repo, ModelMapper mapper) {

        this.exerciseRepository = repo;
        this.mapper = mapper;
    }

    private ExerciseInfoDTO mapToDTO(ExerciseInfo exerciseInfo) {
        return this.mapper.map(exerciseInfo, ExerciseInfoDTO.class);
    }

    public List<ExerciseInfoDTO> readAllExercises() {
        return this.exerciseRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ExerciseInfoDTO createExercise(ExerciseInfo exercise) {
        return this.mapToDTO(this.exerciseRepository.save(exercise));
    }

    public ExerciseInfoDTO findExerciseById(Long id) {
        return this.mapToDTO(this.exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new));
    }

    public ExerciseInfoDTO updateExercise(Long id, ExerciseInfo exerciseInfo) {
        ExerciseInfo update = this.exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
        update.setExerciseTitle(exerciseInfo.getExerciseTitle());
        update.setExerciseDescription(exerciseInfo.getExerciseDescription());
        update.setExerciseDuration(exerciseInfo.getExerciseDuration());
        update.setTargetMuscle(exerciseInfo.getTargetMuscle());
        update.setNumberOfSets(exerciseInfo.getNumberOfSets());
        update.setNumberOfReps(exerciseInfo.getNumberOfReps());
        return this.mapToDTO(this.exerciseRepository.save(exerciseInfo));
    }

    public Boolean deleteExerciseById(Long id) {
        if(!this.exerciseRepository.existsById(id)) {
            throw new ExerciseNotFoundException();
        }
        this.exerciseRepository.deleteById(id);
        return this.exerciseRepository.existsById(id);
    }
}
