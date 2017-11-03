package fr.projet.coran.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Languee implements Serializable{
	private String idLanguee;
	private String nom;
	private Set<Relation> relations;
	
	public Languee() {
		
	}	

	public Languee(String idLanguee, String nom) {
		super();
		this.idLanguee = idLanguee;
		this.nom = nom;
	}



	@Id @Column(name="id_languee", length=3) 
	@NotNull
	 
	public String getIdLanguee() {
		return idLanguee;
	}

	public void setIdLanguee(String idLanguee) {
		this.idLanguee = idLanguee;
	}

	@Column(length=50) 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy="languee", cascade = CascadeType.ALL) 
	public Set<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}

	
	

	
	
	
	
	
	
	
	

}
