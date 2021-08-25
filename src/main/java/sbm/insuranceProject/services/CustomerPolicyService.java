package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.dtos.CustomerPolicyDto;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.CustomerPolicy;
import sbm.insuranceProject.models.PolicyType;

public interface CustomerPolicyService {
	void add(CustomerPolicy customerPolicy);
	List<CustomerPolicy> getAll();
	List<CustomerPolicyDto> getCustomerWithPolicy();
	List<Customer> getAllCustomers();
	List<PolicyType> getAllPolicies();
}
