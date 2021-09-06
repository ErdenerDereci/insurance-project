package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.services.EarthquakeInsuranceService;

@Controller
public class EarthquakeInsuranceController {

	@Autowired
	private EarthquakeInsuranceService earthquakeInsuranceService;
	@GetMapping("/earthquakeInsuranceList")
	public String listEarthquakeInsurances(Model model) {
		model.addAttribute("earthquakeInsuranceList", earthquakeInsuranceService.getAll());
		return "earthquakeInsuranceList";
	}
	
	@GetMapping("/newEarthquakeInsuranceForm")
	public String newEarthquakeInsuranceForm(Model model) {
		EarthquakeInsurance earthquakeInsurance = new EarthquakeInsurance();
		model.addAttribute("customers", earthquakeInsuranceService.getAllCustomers());
		model.addAttribute("earthquakeInsurance", earthquakeInsurance);
		return "newEarthquakeInsuranceForm";
	}
	
	@PostMapping("/addEarthquakeInsurance")
	public String addEarthquakeInsurance(@ModelAttribute("earthquakeInsurance") EarthquakeInsurance earthquakeInsurance) {
		earthquakeInsuranceService.add(earthquakeInsurance);
		return "redirect:/earthquakeInsuranceList";
	}
}
