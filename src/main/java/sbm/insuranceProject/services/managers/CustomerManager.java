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
	public void add(Customer entity) {
		
		boolean result=BusinessRules.CustomerRules.checkTcIfInDatabase(customerDao, entity.getNationalityId());
		if(!result) {
			customerDao.save(entity);
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

	@Override
	public void delete(Customer entity) {
		
		
	}

	@Override
	public void update(Customer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		customerDao.deleteById(id);
		
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
