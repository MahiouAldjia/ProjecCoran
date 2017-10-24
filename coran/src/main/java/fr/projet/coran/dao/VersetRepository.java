package fr.projet.coran.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projet.coran.entities.Verset;

public interface VersetRepository extends JpaRepository<Verset, Integer> {

	
	
}
