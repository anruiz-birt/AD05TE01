package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Diska;
import eus.birt.dam.repository.DiskaRepository;

@Controller
@RequestMapping ("/diskak")
public class DiskaController {

@Autowired
DiskaRepository diskaRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		diskaRepository.deleteById(id);
	return "redirect:/diskak";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Diska diska = new Diska();
		model.addAttribute("diska", diska);
		return "diskaForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Diska diska) {
		diskaRepository.save(diska);
		return "redirect:/diskak";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Integer id, Model model) {	
		model.addAttribute("diska", diskaRepository.findById(id));
		return "diskaForm";
	}
}
