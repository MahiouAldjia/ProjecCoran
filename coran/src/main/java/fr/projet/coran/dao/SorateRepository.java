package fr.projet.coran.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projet.coran.entities.Sorate;
@Repository
public interface SorateRepository extends JpaRepository<Sorate, Integer > {
	@Query("select so from Sorate so where so.nom like:x")
	public Page<Sorate> sorateParMc(@Param("x")String mc, Pageable p);
	
	public List<Sorate> findByNom(String nom);
	public Page<Sorate> findByNom(String nom,Pageable p);

	
}
