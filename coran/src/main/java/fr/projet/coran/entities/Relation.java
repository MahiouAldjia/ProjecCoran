package fr.projet.coran.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="verset_variante_langue")
public class Relation implements Serializable {
	private Verset verset;
	private Variante variante;
	private Languee languee;
	private String ayat;
	
	

	@Id
	
    @ManyToOne
    @JoinColumn(name = "id_verset")
	public Verset getVerset() {
		return verset;
	}

	public void setVerset(Verset verset) {
		this.verset = verset;
	}

	@Id
	
    @ManyToOne
    @JoinColumn(name = "id_variante")
	public Variante getVariante() {
		return variante;
	}

	public void setVariante(Variante variante) {
		this.variante = variante;
	}

	@Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_languee")
	public Languee getLanguee() {
		return languee;
	}

	public void setLanguee(Languee languee) {
		this.languee = languee;
	}

	
	
	public String getAyat() {
		return ayat;
	}

	

	public void setAyat(String ayat) {
		this.ayat = ayat;
	}
	
	public Relation() {
		
	}

	public Relation(Verset verset, Variante variante,Languee languee, String ayat) {
		super();
		this.verset = verset;
		this.variante = variante;
		this.languee = languee;
		this.ayat = ayat;
	}

	
	
	

}
