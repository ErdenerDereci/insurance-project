package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Customer;

public interface CustomerService {

	void add(Customer customer);
	List<Customer> getAll();
}
