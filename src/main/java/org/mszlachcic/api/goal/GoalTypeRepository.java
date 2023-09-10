package org.mszlachcic.api.goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GoalTypeRepository extends JpaRepository<GoalType,Long> {
    GoalType findGoalTypeByName(String name);
}
