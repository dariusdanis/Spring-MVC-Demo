package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
	
}
