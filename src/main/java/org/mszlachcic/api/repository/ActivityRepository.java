package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findActivityByActivityName(String activityName);
}
