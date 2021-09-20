package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.utitilies.forms.CustomerForm;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String getCustomers(Model model) {
		model.addAttribute("customerList", customerService.getAll());
		return "index";
	}
	
	@GetMapping("/newCustomerForm")
	public String newCustomerForm(Model model) {
		
		CustomerForm customerForm= new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		model.addAttribute("result",new Result("",true));
		return "newCustomerForm";
		
	}
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customerForm") CustomerForm customerForm,Model model) {
		Customer customer= mapCustomerFormWithCustomer(customerForm,new Customer());
		Result result=customerService.add(customer);
		if(result.isSuccess()) {
			return "redirect:/";
		}
		model.addAttribute("result", result);
		return "newCustomerForm";
		
	}
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(name="id") int id) {
		//customerService.deleteById(id);
		return "redirect:/";
	}
	@GetMapping("/updateCustomerForm/{id}")
	public String updateCustomerForm(@PathVariable(name="id") int id,Model model) {
		Customer customer = customerService.getById(id);
		CustomerForm customerForm=mapCustomerWithCustomerForm(customer);
		model.addAttribute("customerForm", customerForm);
		return "updateCustomerForm";
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customerForm") CustomerForm customerForm) {;
		
		Customer customer = mapCustomerFormWithCustomer(customerForm,customerService.getById(customerForm.getId()));
		customerService.update(customer);
		return "redirect:/";
	}
	
	private CustomerForm mapCustomerWithCustomerForm(Customer customer) {
		
		CustomerForm customerForm = new CustomerForm();
		customerForm.setId(customer.getId());
		customerForm.setBirthYear(customer.getBirthYear());
		customerForm.setEmail(customer.getEmail());
		customerForm.setGender(customer.getGender());
		customerForm.setName(customer.getName());
		customerForm.setNationalityId(customer.getNationalityId());
		customerForm.setSurname(customer.getSurname());
		
		return customerForm;
	}
	
	private Customer mapCustomerFormWithCustomer(CustomerForm customerForm,Customer customer) {
		

		customer.setBirthYear(customerForm.getBirthYear());
		customer.setEmail(customerForm.getEmail());
		customer.setGender(customerForm.getGender());
		customer.setName(customerForm.getName());
		customer.setNationalityId(customerForm.getNationalityId());
		customer.setSurname(customerForm.getSurname());
		return customer;
		
	}
}
