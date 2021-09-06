package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.services.HealthInsuranceService;

@Controller
public class HealthInsuranceController {

	@Autowired
	private HealthInsuranceService healthInsuranceService;
	@GetMapping("/healthInsuranceList")
	public String listHealthInsurances(Model model) {
		model.addAttribute("healthInsuranceList", healthInsuranceService.getAll());
		return "healthInsuranceList";
	}
	
	@GetMapping("/newHealthInsuranceForm")
	public String newHealthInsuranceForm(Model model) {
		HealthInsurance healthInsurance = new HealthInsurance();
		model.addAttribute("healthInsurance", healthInsurance);
		model.addAttribute("customers", healthInsuranceService.getAllCustomers());
		return "newHealthInsuranceForm";
	}
	
	@PostMapping("/addHealthInsurance")
	public String addHealthInsurance(@ModelAttribute("healthInsurance") HealthInsurance healthInsurance) {
		healthInsuranceService.add(healthInsurance);
		return "redirect:/healthInsuranceList";
	}
}
