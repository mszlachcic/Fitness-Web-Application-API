package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    List<Workout> getWorkoutsByUserUsername(String username);
}
