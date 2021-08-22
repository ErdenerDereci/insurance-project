package sbm.insuranceProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.CustomerDao;
import sbm.insuranceProject.models.Customer;

@Service
public class CustomerManager implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void add(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

}
