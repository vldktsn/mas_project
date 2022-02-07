package edu.pja.mas.s19183.mas.repository;

import edu.pja.mas.s19183.mas.model.Machinist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MachinistRepository extends CrudRepository<Machinist, Long> {

    @Query("from Machinist  as e where e.experienceYears < :experienceyears")
    List<Machinist> checkMachinist(@Param("experienceyears") int experienceyears);
}
