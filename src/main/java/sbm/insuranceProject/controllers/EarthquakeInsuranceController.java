package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.EarthquakeInsuranceService;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;

import java.util.List;

@Controller
public class EarthquakeInsuranceController {

	@Autowired
	private EarthquakeInsuranceService earthquakeInsuranceService;
	@GetMapping("/earthquakeInsuranceList")
	public String listEarthquakeInsurances(Model model) {
		model.addAttribute("earthquakeInsuranceList", earthquakeInsuranceService.getAll());
		model.addAttribute("result", new Result("", true));
		return "earthquakeInsuranceList";
	}
	
	@GetMapping("/newEarthquakeInsuranceForm")
	public String newEarthquakeInsuranceForm(Model model) {
		EarthquakeInsuranceForm earthquakeInsuranceForm = new EarthquakeInsuranceForm();
		List<EarthquakeInsurance> earthquakeInsurances = earthquakeInsuranceService.getAll();
		List<Customer> customers =earthquakeInsuranceService.getAllCustomers();
		model.addAttribute("customers",customers);
		if (customers.size()==0){
			model.addAttribute("earthquakeInsuranceList", earthquakeInsurances);
			model.addAttribute("result",new Result("Deprem sigortasi eklenmesi veritabaninda en az bir tane musteri verisi olmak zorundadir." +
					"Musteri ekleyip tekrar deneyiniz.",false));
			return "earthquakeInsuranceList";
		}
		model.addAttribute("result", new Result("", true));
		model.addAttribute("EarthquakeInsuranceForm", earthquakeInsuranceForm);
		return "newEarthquakeInsuranceForm";
	}
	
	@PostMapping("/addEarthquakeInsurance")
	public String addEarthquakeInsurance(@ModelAttribute("EarthquakeInsuranceForm") EarthquakeInsuranceForm earthquakeInsuranceForm,Model model) {
		Result result=earthquakeInsuranceService.add(earthquakeInsuranceForm);

		if(!result.isSuccess()){
			model.addAttribute("result",result);
			model.addAttribute("customers", earthquakeInsuranceService.getAllCustomers());
			return "newEarthquakeInsuranceForm";
		}
		model.addAttribute("result",result);
		return "redirect:/earthquakeInsuranceList";
	}
	@GetMapping("/deleteEarthquakeInsurance/{id}")
	public String deleteEarthquakeInsuance(@PathVariable(name="id") int id) {
		earthquakeInsuranceService.deleteById(id);
		return "redirect:/earthquakeInsuranceList";
	}
}
