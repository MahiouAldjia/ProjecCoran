package fr.projet.coran.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.projet.coran.dao.SorateRepository;
import fr.projet.coran.entities.Sorate;

@Controller
@RequestMapping(value="/Coran")
public class CoranController {
	@Autowired
	private SorateRepository sorateRepository;
	//Afficher toutes les sorate
	/**@RequestMapping("/Index")
	public String Index(Model model) {
		List<Sorate> srt= sorateRepository.findAll();
		model.addAttribute("sorates", srt);
		return "sorates";
	}**/
	
	//Afficher par page
	/** 
	 * si on utilise pas defaultValue="0" sa genere une exception
	 * si on utilise pas @RequestParam(name="page") sa genere une exception
	 * mais si on change au niveau de l'url page par p sa va marcher
	 * 2- conaitre les pages et afficher lespages
	 */
	@RequestMapping("/Index")
	public String Index(Model model,
			@RequestParam(name="page", defaultValue="0")int p) {
		Page<Sorate> pageSorates= sorateRepository.findAll(
				new PageRequest(p, 5)); {
		/**
		 * 2- conaitre les pages et afficher lespages
		 */
		int pageCount= pageSorates.getTotalPages();
		int[] pages =new int[pageCount];
		for(int i=0;i<pageCount; i++) {
			pages[i]=i;
		}
		/**
		 * sauvegarder dans le model
		 */
		model.addAttribute("pages", pages);
		model.addAttribute("pageSorates", pageSorates);
		return "sorates";
	}
	}
	/**@RequestMapping("/save")
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
	}**/
	

}
