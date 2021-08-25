package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAll());
		return "index";
	}
	
	@GetMapping("/newCustomerForm")
	public String newCustomerForm(Model model) {
		Customer customer= new Customer();
		model.addAttribute("customer", customer);
		return "newCustomerForm";
	}
	
	@PostMapping("/addCustomer")
	public String addPolicy(@ModelAttribute("customer") Customer customer) {
		customerService.add(customer);
		return "redirect:/";
	}
}