package com.qa.exerciseapp.repo;

import com.qa.exerciseapp.domain.Pumpit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpitRepository extends JpaRepository<Pumpit, Long> {

}
