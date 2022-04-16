package org.mszlachcic.api.repository;

import java.util.Optional;

import org.mszlachcic.api.entities.Role;
import org.mszlachcic.api.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
