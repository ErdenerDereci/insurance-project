package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Person;
import sbm.insuranceProject.services.PersonService;



@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("listCustomers", personService.getAll());
		return "index";
	}
	
	@GetMapping("/newCustomerForm")
	public String newCustomerForm(Model model) {
		Person customer= new Person();
		model.addAttribute("customer", customer);
		return "newCustomerForm";
	}
	
	@PostMapping("/addCustomer")
	public String addPolicy(@ModelAttribute("customer") Person person) {
		personService.add(person);
		return "redirect:/";
	}
}
