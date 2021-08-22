package sbm.insuranceProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Policy;
import sbm.insuranceProject.services.PolicyService;

@Controller
public class PolicyController {

	@Autowired
	PolicyService policyService;
	
	@GetMapping("/listPolicies")
	public String listPolicies(Model model) {
		model.addAttribute("getAllPolicies", policyService.GetAll());
		return "listPolicies";
	}
	
	@GetMapping("/newPolicyForm")
	public String newpolicyForm(Model model) {
		Policy policy = new Policy();
		model.addAttribute("policy", policy);
		return "newPolicyForm";
	}
	
	@PostMapping("/addPolicy")
	public String addPolicy(@ModelAttribute("policy") Policy policy) {
		policyService.Add(policy);
		return "redirect:/listPolicies";
	}
}
