package sbm.insuranceProject.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.abstracts.CustomerDao;
import sbm.insuranceProject.abstracts.CustomerService;
import sbm.insuranceProject.domain.Customer;

@Service
public class CustomerManager implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
		System.out.println("customer saved");
	}
	
}
