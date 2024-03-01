package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.AbestiaRepository;
import eus.birt.dam.repository.DiskaRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private AbestiaRepository abestiaRepository;
	@Autowired
   	private DiskaRepository diskaRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/abestiak"})
	public String getAbestiak(Model model) {
		model.addAttribute("abestiak", abestiaRepository.findAll());
		return "abestiak";
	}
	
	@GetMapping ({"/diskak"})
	public String getTeams(Model model) {
		model.addAttribute("diskak", diskaRepository.findAll());
		return "diskak";
	}
}
	

