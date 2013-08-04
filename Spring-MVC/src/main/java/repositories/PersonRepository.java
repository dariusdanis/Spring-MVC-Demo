package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
