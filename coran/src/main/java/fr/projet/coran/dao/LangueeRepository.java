package fr.projet.coran.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projet.coran.entities.Languee;

public interface LangueeRepository extends JpaRepository<Languee, String> {

}
