package org.mszlachcic.api.party;

import org.mszlachcic.api.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,Long> {
    Party findPartyById(Long id);

}
