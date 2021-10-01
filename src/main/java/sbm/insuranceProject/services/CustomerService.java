package sbm.insuranceProject.services;

import sbm.insuranceProject.models.Customer;

import java.util.List;

public interface CustomerService extends ServiceBase<Customer> {

		int customerInsuranceCount(int customerId);
		void setStatus(boolean status,int customerId);
		List<Customer> getAllTrue();
		List<Customer> getAllFalse();
	
}
