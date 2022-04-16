package org.mszlachcic.api.repository;

import org.mszlachcic.api.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findAllByCity_Name(String name);
    Route findByName(String name);
}
