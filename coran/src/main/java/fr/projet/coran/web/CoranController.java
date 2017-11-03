package fr.projet.coran.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			@RequestParam(name="page", defaultValue="0")int p,
			@RequestParam(name="motCle", defaultValue=" ")String mc) {
		
		Page<Sorate> pageSorates= sorateRepository
				.chercherSorate("%"+mc+"%", new PageRequest(p, 5)); 
		/**
		 * 2- conaitre les pages et afficher lespages
		 */
		int pageCount= pageSorates.getTotalPages();
		int[] pages =new int[pageCount];
		for(int i=0;i<pageCount; i++)pages[i]=i;
		
		/**
		 * sauvegarder dans le model
		 */
		model.addAttribute("pages", pages);
		model.addAttribute("pageSorates", pageSorates);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "sorates";
	}				
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String formSorate(Model model) {
		model.addAttribute("sorate", new Sorate());		
		return "FormSorate";
	}
	@RequestMapping(value="/SaveSorate", method=RequestMethod.POST)
	public String save(@Valid Sorate st, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "FormSorate";
		}
		sorateRepository.save(st);
		
		return "redirect:Index";
	}
	@RequestMapping(value="/supprimer")
	public String supprimer(int idSorate) {
		sorateRepository.delete(idSorate);
		return "redirect:Index";
	}
	
	@RequestMapping(value="/edit")
	public String edit(int idSorate, Model model) {
		Sorate st = sorateRepository.findOne(idSorate);
		model.addAttribute("sorate", st);
		return "EditSorate";
	}
	@RequestMapping(value="/UpdateSorate", method=RequestMethod.POST)
	public String update(@Valid Sorate st, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "EditSorate";
		}
		sorateRepository.save(st);
		
		return "redirect:Index";
	}
	

}
