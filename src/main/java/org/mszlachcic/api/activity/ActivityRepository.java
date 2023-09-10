package org.mszlachcic.api.activity;

import org.mszlachcic.api.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findActivityByActivityName(String activityName);
}
