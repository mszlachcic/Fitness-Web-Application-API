package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint,Long> {
}
