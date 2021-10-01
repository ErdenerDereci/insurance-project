package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.models.Illness;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerIllnessService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.services.IllnessService;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.AddHealthInsuranceForm;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.HealthInsuranceForm;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HealthInsuranceController {

	private List<Illness> illnesses = new ArrayList<>();
	@Autowired
	private HealthInsuranceService healthInsuranceService;
	@Autowired
	private IllnessService illnessService;
	@Autowired
	private CustomerIllnessService customerIllnessService;

	@GetMapping("/healthInsuranceList")
	public String listHealthInsurances(Model model) {
		List<HealthInsuranceForm> healthInsuranceForms = healthInsuranceService.getAllHealthInsuranceForm();
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		model.addAttribute("result", new Result("", true));
		model.addAttribute("healthInsuranceForms",healthInsuranceForms);
		return "healthInsuranceList";
	}


	@GetMapping("/newHealthInsuranceForm")
	public String newHealthInsuranceForm(Model model) {
		AddHealthInsuranceForm addHealthInsuranceForm = new AddHealthInsuranceForm();
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		List<HealthInsuranceForm> healthInsuranceForms = healthInsuranceService.getAllHealthInsuranceForm();
		if (customers.size()==0) {
			model.addAttribute("result", new Result("Saglik sigortasi eklemeden once en az bir musteri eklemeniz gerekmektedir", false));
			model.addAttribute("healthInsuranceForms",healthInsuranceForms);
			return "healthInsuranceList";
		}
		model.addAttribute("result",new Result("",true));
		model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
		model.addAttribute("customers",customers);
		model.addAttribute("illnesses",illnesses);
		return "newHealthInsuranceForm";
	}
	@GetMapping("/newIllnessForm")
	public String newIllnessForm(Model model) {

		model.addAttribute("result",new Result("",true));
		Illness illness = new Illness();
		model.addAttribute("illness",illness);
		model.addAttribute("illnessList",illnessService.getAll());
		return "newIllnessForm";
	}
	
	@PostMapping("/addIllness")
	public String addIllness(@ModelAttribute("illness") Illness illness, Model model) {

		Optional<Illness> x=illnessService.findById(illness.getId());
		model.addAttribute("result",new Result("",true));
		for (Illness illness1 :illnesses) {
			if(illness1.getId()==illness.getId()){
				model.addAttribute("result", new Result("",false));
				model.addAttribute("illnessList",illnessService.getAll());
				return "newIllnessForm";
			}
		}

		illnesses.add(x.get());
		return "redirect:/newHealthInsuranceForm";
	}

	@PostMapping("/addHealthInsurance")
	public String addHealthInsurance(@ModelAttribute("addHealthInsuranceForm") AddHealthInsuranceForm addHealthInsuranceForm,Model model) {


		addHealthInsuranceForm.setIllnesses(illnesses);

		if(illnesses.size()==0){
			Result result1 = new Result("Hastalik eklenmesi zorunludur.",false);
			model.addAttribute("result",result1);
			model.addAttribute("customers", healthInsuranceService.getAllCustomers());
			model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
			return "newHealthInsuranceForm";
		}

		Result result=healthInsuranceService.add(addHealthInsuranceForm);
		if(!result.isSuccess()){
			model.addAttribute("result",result);
			model.addAttribute("customers", healthInsuranceService.getAllCustomers());
			model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
			model.addAttribute("illnesses",illnesses);
			return "newHealthInsuranceForm";
		}

		CustomerIllness customerIllness;
		for (Illness illness: illnesses) {
			customerIllness=new CustomerIllness();
			customerIllness.setCustomerId(addHealthInsuranceForm.getCustomer().getId());
			customerIllness.setIllnessId(illness.getId());
			customerIllnessService.add(customerIllness);
		}

		illnesses.clear();
		return "redirect:/healthInsuranceList";
	}
	
	@GetMapping("/deleteHealthInsurance/{id}")
	public String deleteHealthInsuance(@PathVariable(name="id") int id) {
		healthInsuranceService.deleteById(id);
		return "redirect:/healthInsuranceList";
	}
	@RequestMapping("/deleteFromIllnessList/{id}")
	public String deleteIllnessFromList(@PathVariable(name="id") int id){
		Illness temp=null;
		for (Illness illness : illnesses) {
			if(illness.getId()==id){
				temp = illness;
			}
		}
		illnesses.remove(temp);
		return "redirect:/newHealthInsuranceForm";
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
