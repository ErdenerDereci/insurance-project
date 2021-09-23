package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.services.IllnessService;
import sbm.insuranceProject.utitilies.forms.HealthInsuranceForm;

import java.util.List;

@Controller
public class HealthInsuranceController {

	@Autowired
	private HealthInsuranceService healthInsuranceService;
	@Autowired
	private IllnessService illnessService;


	@GetMapping("/healthInsuranceList")
	public String listHealthInsurances(Model model) {
		List<HealthInsuranceForm> ff = healthInsuranceService.getAllHealthInsuranceForm();
		model.addAttribute("healthInsuranceForms",ff);
		return "healthInsuranceList";
	}
	
	@GetMapping("/newHealthInsuranceForm")
	public String newHealthInsuranceForm(Model model) {
		HealthInsurance healthInsurance = new HealthInsurance();
		model.addAttribute("healthInsurance", healthInsurance);
		model.addAttribute("customers", healthInsuranceService.getAllCustomers());
		model.addAttribute("illnesses",illnessService.getAll());
		return "newHealthInsuranceForm";
	}
	
	@PostMapping("/addHealthInsurance")
	public String addHealthInsurance(@ModelAttribute("healthInsurance") HealthInsurance healthInsurance) {
		healthInsuranceService.add(healthInsurance);
		return "redirect:/healthInsuranceList";
	}
	
	@GetMapping("/deleteHealthInsurance/{id}")
	public String deleteHealthInsuance(@PathVariable(name="id") int id) {
		healthInsuranceService.deleteById(id);
		return "redirect:/healthInsuranceList";
	}
	
	/*
	@GetMapping("/updateHealthInsuranceForm/{id}")
	public String updateHealthInsuance(@PathVariable(name="id") int id,Model model) {
		
		model.addAttribute("healthInsurance", healthInsuranceService.getById(id));
		model.addAttribute("customers", healthInsuranceService.getAllCustomers());
		return "updateHealthInsuranceForm";
	}
	@PostMapping("/updateHealthInsurance")
	public String updateHealthInsurance(@ModelAttribute("healthInsurance") HealthInsurance healthInsurance) {
		healthInsuranceService.update(healthInsurance);
		return "redirect:/healthInsuranceList";
	}*/
}
