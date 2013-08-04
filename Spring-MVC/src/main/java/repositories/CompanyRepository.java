package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
