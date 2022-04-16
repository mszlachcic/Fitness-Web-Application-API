package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository <Goal,Long> {
    List<Goal> findAllByUser_Username(String username);
}
