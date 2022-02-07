package edu.pja.mas.s19183.mas.repository;

import edu.pja.mas.s19183.mas.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
