package fr.projet.coran.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projet.coran.entities.Relation;

public interface RelationRepository extends JpaRepository<Relation, Integer>{

}
