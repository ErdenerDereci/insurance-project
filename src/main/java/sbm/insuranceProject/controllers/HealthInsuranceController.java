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

	@Autowired
	private HealthInsuranceService healthInsuranceService;
	@Autowired
	private IllnessService illnessService;
	@Autowired
	private CustomerIllnessService customerIllnessService;

 	List<Illness> illnesses = new ArrayList<>();
	@GetMapping("/healthInsuranceList")

	public String listHealthInsurances(Model model) {
		illnesses.clear();
		List<HealthInsuranceForm> healthInsuranceForms = healthInsuranceService.getAllHealthInsuranceForm();
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		model.addAttribute("result",new Result("",true));
		model.addAttribute("healthInsuranceForms",healthInsuranceForms);
		return "healthInsuranceList";
	}


	@GetMapping("/newHealthInsuranceForm")
	public String newHealthInsuranceForm(Model model) {
		AddHealthInsuranceForm addHealthInsuranceForm = new AddHealthInsuranceForm();
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		List<Illness> illnessList = illnessService.getAll();

		if (customers.size()==0) {
			model.addAttribute("result",new Result("Saglik sigortasi eklemeden " +
					"once en az bir musteri eklemeniz gerekmektedir", false));
			List<HealthInsuranceForm> healthInsuranceForms = healthInsuranceService.getAllHealthInsuranceForm();
			model.addAttribute("healthInsuranceForms",healthInsuranceForms);

		return "healthInsuranceList";
		}
		model.addAttribute("result",new Result("",true));
		model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
		model.addAttribute("customers",customers);
		model.addAttribute("illnessList",illnessList);
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
	
	@GetMapping("/addIllness/{id}")
	public String addIllness(@PathVariable(name="id") int id, Model model) {
		AddHealthInsuranceForm addHealthInsuranceForm = new AddHealthInsuranceForm();
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		List<Illness> illnessList = illnessService.getAll();

		Optional<Illness> x=illnessService.findById(id);
		for (Illness illness1 :illnesses) {
			if(illness1.getId()==id){

				model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
				model.addAttribute("customers",customers);
				model.addAttribute("illnessList",illnessList);
				model.addAttribute("illnesses",illnesses);
				model.addAttribute("result", new Result("Bu hastalik zaten eklenmis!",false));
				return "newHealthInsuranceForm";
			}
		}
		illnesses.add(x.get());
		return "redirect:/newHealthInsuranceForm";
	}

	@PostMapping("/addHealthInsurance")
	public String addHealthInsurance(@ModelAttribute("addHealthInsuranceForm") AddHealthInsuranceForm addHealthInsuranceForm,Model model) {
		List<Customer> customers =  healthInsuranceService.getAllCustomers();
		List<Illness> illnessList = illnessService.getAll();


		if(illnesses.size()==0){

			model.addAttribute("result",new Result("Hastalik eklenmesi zorunludur.",false));
			return "redirect:/newHealthInsuranceForm";
		}

		addHealthInsuranceForm.setIllnesses(illnesses);
		Result result1=healthInsuranceService.add(addHealthInsuranceForm);
		if(!result1.isSuccess()){
			model.addAttribute("result",result1);
			model.addAttribute("addHealthInsuranceForm", addHealthInsuranceForm);
			model.addAttribute("customers",healthInsuranceService.getAllCustomers());
			model.addAttribute("illnessList",illnessService.getAll());
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
