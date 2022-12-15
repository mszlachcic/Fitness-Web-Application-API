package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    List<Workout> getWorkoutsByUserUsername(String username);
    @Query("select w from Workout w where w.user.username = :username and w.start between :startDate and :endDate")
    List<Workout> getWorkoutsBetweenDates(LocalDateTime startDate, LocalDateTime endDate,String username);
    Workout findWorkoutById(Long id);
    @Query(nativeQuery = true,value = "select distinct * from workout order by start desc limit 15")
    List<Workout> get50MostRecentWorkoutsOfAllUsers();

//    @Query(nativeQuery = true,value = "select * from workout order by start desc limit 15 where")
//    List<Workout> get15WorkoutsByUsername();
}
