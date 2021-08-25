package sbm.insuranceProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.CustomerPolicyDao;
import sbm.insuranceProject.dtos.CustomerPolicyDto;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.CustomerPolicy;
import sbm.insuranceProject.models.PolicyType;

@Service
public class CustomerPolicyManager implements CustomerPolicyService{

	
	private CustomerPolicyDao customerPolicyDao;
	private CustomerService customerService;
	private PolicyService policyService;
	
	
	@Autowired
	public CustomerPolicyManager(CustomerPolicyDao customerPolicyDao, CustomerService customerService,
			PolicyService policyService) {
		super();
		this.customerPolicyDao = customerPolicyDao;
		this.customerService = customerService;
		this.policyService = policyService;
	}

	@Override
	public void add(CustomerPolicy customerPolicy) {
		customerPolicyDao.save(customerPolicy);
		
	}

	@Override
	public List<CustomerPolicy> getAll() {
		
		return customerPolicyDao.findAll() ;
	}

	@Override
	public List<CustomerPolicyDto> getCustomerWithPolicy() {
		return customerPolicyDao.getCustomerWithPolicy();
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerService.getAll();	
	}

	@Override
	public List<PolicyType> getAllPolicies() {
		// TODO Auto-generated method stub
		return policyService.GetAll();
	}

}
