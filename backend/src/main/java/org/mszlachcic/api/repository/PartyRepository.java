package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,Long> {
    Party findPartyById(Long id);

}
