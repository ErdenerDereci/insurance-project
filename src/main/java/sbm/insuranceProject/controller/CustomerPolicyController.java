package sbm.insuranceProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.CustomerPolicy;
import sbm.insuranceProject.services.CustomerPolicyService;

@Controller
public class CustomerPolicyController {

	@Autowired
	private CustomerPolicyService customerPolicyService;
	
	@GetMapping("/listCustomerPolicies")
	public String listCustomerPolicies(Model model) {
		model.addAttribute("customerPolicies", customerPolicyService.getCustomerWithPolicy());
		return "listCustomerPolicies";
	}
	
	@GetMapping("/newCustomerPolicyForm")
	public String newCustomerPolicyForm(Model model) {
		model.addAttribute("customers", customerPolicyService.getAllCustomers());
		model.addAttribute("policies", customerPolicyService.getAllPolicies());
		CustomerPolicy customerPolicy= new CustomerPolicy();
		model.addAttribute("customerPolicy", customerPolicy);
		return "/newCustomerPolicyForm";
	}
	
	@PostMapping("/addCustomerPolicy")
	public String addCustomerPolicy(@ModelAttribute("customerPolicy") CustomerPolicy customerPolicy) {
		customerPolicyService.add(customerPolicy);
		return "redirect:/";
	}
}
