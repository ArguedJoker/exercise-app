package com.qa.exerciseapp.repo;

import com.qa.exerciseapp.domain.ExerciseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseInfo, Long> {

}
