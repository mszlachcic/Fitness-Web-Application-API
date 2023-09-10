package org.mszlachcic.api.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    Route findByName(String name);

    @Query(value = "select r from Route r inner join Address a on r.address.id = a.id " +
            "where a.address like %:name%")
    List<Route> getRoutesByCityName(String name);
}
