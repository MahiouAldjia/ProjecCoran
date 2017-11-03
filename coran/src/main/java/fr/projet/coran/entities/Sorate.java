package fr.projet.coran.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Sorate implements Serializable{
	
	private int idSorate;
	@NotEmpty(message="Remplir le champs")
	@Size(min=5, max=30, message="la taille de  compris entre<5,30>")
	private String nom;
	private Collection<Verset> versets;
	
	
	public Sorate() {
		
	}

	public Sorate(String nom) {
		
		this.nom = nom;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	//@Size(min = 1, max = 9)
	 @Column(name="id_sorate")
	
	public int getIdSorate() {
		return idSorate;
	}

	public void setIdSorate(int idSorate) {
		this.idSorate = idSorate;
	}
	
	//@NotEmpty
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy="sorate",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//@NotEmpty
	public Collection<Verset> getVersets() {
		return versets;
	}

	public void setVersets(Collection<Verset> versets) {
		this.versets = versets;
	}
	

	
	
	
	
	

}
