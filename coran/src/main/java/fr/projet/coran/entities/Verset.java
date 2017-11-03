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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Verset implements Serializable{
	private int idVerset;
	private int numero;
	private Sorate sorate;
	private Set<Relation> relations;
	
	public Verset() {
		
	}

	public Verset(int numero, Sorate sorate) {
		super();
		this.numero = numero;
		this.sorate = sorate;
		relations = new HashSet<>();
	}



	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_verset")
	public int getIdVerset() {
		return idVerset;
	}

	public void setIdVerset(int idVerset) {
		this.idVerset = idVerset;
	}

	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@ManyToOne
    @JoinColumn(name = "id_sorate")
	
	public Sorate getSorate() {
		return sorate;
	}

	public void setSorate(Sorate sorate) {
		this.sorate = sorate;
	}

	@OneToMany(mappedBy="verset", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}

	
	
	

	
	
	
	
	
	

}
