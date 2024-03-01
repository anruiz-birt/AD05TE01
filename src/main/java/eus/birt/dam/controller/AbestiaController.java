package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Abestia;
import eus.birt.dam.repository.AbestiaRepository;
import eus.birt.dam.repository.DiskaRepository;

@Controller
@RequestMapping ("/abestiak")
public class AbestiaController {

	@Autowired
	AbestiaRepository abestiaRepository;
	
	@Autowired
	DiskaRepository diskaRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Integer id) {
		abestiaRepository.deleteById(id);
		return "redirect:/abestiak";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Abestia abestia = new Abestia();
		model.addAttribute("abestia", abestia);
		model.addAttribute("diskak", diskaRepository.findAll());
		return "abestiaForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Abestia abestia) {
		abestiaRepository.save(abestia);
		return "redirect:/abestiak";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Integer id, Model model) {	
		model.addAttribute("abestia", abestiaRepository.findById(id));
		model.addAttribute("diskak", diskaRepository.findAll());
		return "abestiaForm";
	}
}