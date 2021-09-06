package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.CustomerDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.utitilies.BusinessRules;

@Service
public class CustomerManager implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void add(Customer person) {
		
		boolean result=BusinessRules.CustomerRules.checkTcIfInDatabase(customerDao, person.getNationalityId());
		if(!result) {
			customerDao.save(person);
		}
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	@Override
	public int customerInsuranceCount(int customerId) {
		return customerDao.customerInsuranceCount(customerId);
	}

	

	

}
