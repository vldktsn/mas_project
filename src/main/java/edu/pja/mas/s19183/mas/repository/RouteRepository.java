package edu.pja.mas.s19183.mas.repository;

import edu.pja.mas.s19183.mas.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("delete from Route e where e.id = :Id")
    void removeRouteById(@Param("Id") long Id);
}
