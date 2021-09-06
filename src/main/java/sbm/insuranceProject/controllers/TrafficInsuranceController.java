package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.services.TrafficInsuranceService;

@Controller
public class TrafficInsuranceController {

	@Autowired
	private TrafficInsuranceService trafficInsuranceService;
	@GetMapping("/trafficInsuranceList")
	public String listTrafficInsurances(Model model) {
		model.addAttribute("trafficInsuranceList", trafficInsuranceService.getAll());
		return "trafficInsuranceList";
	}
	
	@GetMapping("/newTrafficInsuranceForm")
	public String newTrafficInsuranceForm(Model model) {
		TrafficInsurance trafficInsurance = new TrafficInsurance();
		model.addAttribute("trafficInsurance", trafficInsurance);
		model.addAttribute("customers", trafficInsuranceService.getAllCustomers());
		return "newTrafficInsuranceForm";
	}
	
	@PostMapping("/addTrafficInsurance")
	public String addTrafficInsurance(@ModelAttribute("trafficInsurance") TrafficInsurance trafficInsurance) {
		trafficInsuranceService.add(trafficInsurance);
		return "redirect:/trafficInsuranceList";
	}
}
