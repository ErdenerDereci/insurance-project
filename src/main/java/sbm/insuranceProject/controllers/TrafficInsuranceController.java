package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.EarthquakeInsuranceService;
import sbm.insuranceProject.services.TrafficInsuranceService;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.HealthInsuranceForm;
import sbm.insuranceProject.utitilies.forms.trafficInsuranceForms.TrafficInsuranceForm;

import java.util.List;

@Controller
public class TrafficInsuranceController {

	@Autowired
	private TrafficInsuranceService trafficInsuranceService;
	@GetMapping("/trafficInsuranceList")
	public String listTrafficInsurances(Model model) {
		model.addAttribute("trafficInsuranceList", trafficInsuranceService.getAll());
		model.addAttribute("result", new Result("", true));
		return "trafficInsuranceList";
	}

	@GetMapping("/newTrafficInsuranceForm")
	public String newTrafficInsuranceForm(Model model) {
		TrafficInsuranceForm trafficInsuranceForm = new TrafficInsuranceForm();
		List<Customer> customers =trafficInsuranceService.getAllCustomers();
		List<TrafficInsurance> trafficInsurances = trafficInsuranceService.getAll();
		model.addAttribute("customers",customers);
		if (customers.size()==0){
			model.addAttribute("trafficInsuranceList", trafficInsurances);
			model.addAttribute("result",new Result("Trafik sigortasi eklenmesi icin veritabaninda en az bir tane musteri verisi olmak zorundadir." +
					"Musteri ekleyip tekrar deneyiniz.",false));
			return "trafficInsuranceList";
		}
		model.addAttribute("result", new Result("", true));
		model.addAttribute("TrafficInsuranceForm", trafficInsuranceForm);
		return "newTrafficInsuranceForm";
	}

	@PostMapping("/addTrafficInsurance")
	public String addTrafficInsurance(@ModelAttribute("TrafficInsuranceForm") TrafficInsuranceForm trafficInsuranceForm,Model model) {
		Result result=trafficInsuranceService.add(trafficInsuranceForm);

		if(!result.isSuccess()){
			model.addAttribute("result",result);
			model.addAttribute("customers", trafficInsuranceService.getAllCustomers());
			return "newTrafficInsuranceForm";
		}
		model.addAttribute("result",result);
		return "redirect:/trafficInsuranceList";
	}
	@GetMapping("/deleteTrafficInsurance/{id}")
	public String deleteTrafficInsurance(@PathVariable(name="id") int id) {
		trafficInsuranceService.deleteById(id);
		return "redirect:/trafficInsuranceList";
	}

}
