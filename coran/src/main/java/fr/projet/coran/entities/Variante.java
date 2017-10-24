package fr.projet.coran.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Variante implements Serializable{
	private int idVariante;
	private String nom;
	private Set<Relation> relations;
	
	public Variante() {
		
	}

	public Variante(String nom) {
		
		this.nom = nom;
		relations = new HashSet<>();
		
	}

	@Id @GeneratedValue
	 @Column(name="id_variante")
	public int getIdVariante() {
		return idVariante;
	}

	public void setIdVariante(int idVariante) {
		this.idVariante = idVariante;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy="variante", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}
	
	
	
	
	
	
	
	
	
	

}
