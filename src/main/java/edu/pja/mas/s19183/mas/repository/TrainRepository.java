package edu.pja.mas.s19183.mas.repository;

import edu.pja.mas.s19183.mas.model.Train;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TrainRepository extends CrudRepository<Train, Long> {


    @Query("from Train  as e where e.trainStatus = :types")
    List<Train> checkTrain(@Param("types") Set<String> types);


}
