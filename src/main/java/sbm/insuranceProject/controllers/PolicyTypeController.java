package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.PolicyType;
import sbm.insuranceProject.services.PolicyTypeService;


@Controller
public class PolicyTypeController {

	@Autowired
	PolicyTypeService policyTypeService;
	
	@GetMapping("/listPolicies")
	public String listPolicies(Model model) {
		model.addAttribute("getAllPolicies", policyTypeService.GetAll());
		return "listPolicies";
	}
	
	@GetMapping("/newPolicyForm")
	public String newpolicyForm(Model model) {
		PolicyType policy = new PolicyType();
		model.addAttribute("policy", policy);
		return "newPolicyForm";
	}
	
	@PostMapping("/addPolicy")
	public String addPolicy(@ModelAttribute("policy") PolicyType policy) {
		policyTypeService.Add(policy);
		return "redirect:/listPolicies";
	}
}
