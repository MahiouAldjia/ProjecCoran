package fr.projet.coran;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.projet.coran.dao.LangueeRepository;
import fr.projet.coran.dao.SorateRepository;
import fr.projet.coran.dao.VarianteRepository;
import fr.projet.coran.dao.VersetRepository;

import fr.projet.coran.entities.Languee;
import fr.projet.coran.entities.Relation;
import fr.projet.coran.entities.Sorate;
import fr.projet.coran.entities.Variante;
import fr.projet.coran.entities.Verset;





@SpringBootApplication
public class CoranApplication implements CommandLineRunner {
	
	@Autowired
	private SorateRepository sorateRepository;
	@Autowired
	private VersetRepository versetRepository;
	@Autowired
	private LangueeRepository langueeRepository;
	
	@Autowired
	private VarianteRepository varianteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CoranApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		/**Sorate s1=sorateRepository.save(new Sorate("EL FATIHA"));
		Sorate s2=sorateRepository.save(new Sorate("EL BAKARA"));
		
		Verset v1= versetRepository.save(new Verset(1, s1));
		Languee l1= langueeRepository.save(new Languee("ara", "arabe"));
		Variante vt1 =varianteRepository.save(new Variante("hafs"));
		Relation relation =new Relation(v1, vt1, l1, "bismi allah");
		v1.getRelations().add(relation);**/
	    //sorateRepository.delete(1);		
		
	}

	
		
	
}
