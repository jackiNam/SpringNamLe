package com.ptit.namle.CRUDspring2.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.namle.CRUDspring2.entity.Person;
import com.ptit.namle.CRUDspring2.respondstory.PersonRepository;





@Controller
@RequestMapping("user")
public class PersonController {

	@Autowired
	PersonRepository personRepository ;
	// them
	@GetMapping("/create")
	public String create() {
		return "user/createUser" ;	
	}
	@PostMapping("/post")
	public String create(@ModelAttribute Person person) {
		personRepository.save(person);
		return "redirect:/user/searchUser";	
	}
	// xoa 
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		personRepository.deleteById(id);
		return "redirect:/user/searchUser";	
	}
	// sua 
	@GetMapping("/edit")
	public String edit(Model model ,@Param("id") int id) {
		Person person = personRepository.getById(id);
		model.addAttribute("person", person);
		return "user/editUser" ;	
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("person") Person person) {
		personRepository.save(person);
		return "redirect:/user/searchUser";	
	}
	// search 
	@GetMapping("/search")
	public String search(Model model) {
		List<Person> persons = personRepository.findAll();
		model.addAttribute("Listperson", persons);
		return "user/searchUser";	
	}
}
