package org.mszlachcic.api.goal;

import org.mszlachcic.api.goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository <Goal,Long> {
    List<Goal> findAllByUser_Username(String username);
    List<Goal> findAllByUserId(Long id);

}
