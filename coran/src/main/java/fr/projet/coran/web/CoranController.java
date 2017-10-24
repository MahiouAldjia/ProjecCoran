package fr.projet.coran.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.coran.dao.SorateRepository;
import fr.projet.coran.entities.Sorate;

@RestController
public class CoranController {
	@Autowired
	private SorateRepository sorateRepository;
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@RequestMapping("/save")
	public Sorate saveSorate(Sorate s) {
		sorateRepository.save(s);
		return s;
	}
	@RequestMapping("/all")
	public List<Sorate> getSorate() {
		return sorateRepository.findAll();
	}
	@RequestMapping("/sorates")
	public Page<Sorate> getSorates(int page) {
		return sorateRepository.findAll(new PageRequest(page, 7));
	}
	
	@RequestMapping("/sorateParMC")
	public Page<Sorate> getSorates(String mc,int page) {
		return sorateRepository.sorateParMc("%"+mc+"%", new PageRequest(page, 5));
	}
	
	@RequestMapping("/get")
	public Sorate getSorate(int idSorate) {
		return sorateRepository.findOne(idSorate);
	}
	
	@RequestMapping("/delete")
	public boolean delete(int idSorate) {
		sorateRepository.delete(idSorate);
		return true;
	}
	
	@RequestMapping("/update")
	public Sorate update(Sorate s) {
		sorateRepository.saveAndFlush(s);
		return s;
	}
	

}
