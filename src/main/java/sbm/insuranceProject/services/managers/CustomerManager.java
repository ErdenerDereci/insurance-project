package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.CustomerDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.utitilies.BusinessRules;

@Service
public class CustomerManager implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Result add(Customer entity) {
		
		boolean result=BusinessRules.CustomerRules.checkTcIfInDatabase(customerDao, entity.getNationalityId());
		if(!result) {
			customerDao.save(entity);
			return new Result("Kisi kaydedildi.",true);
		}
		return new Result("Bu kisi zaten veritabaninda mecvut",false);
		
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
	public void setStatus(boolean status, int customerId) {
		customerDao.setStatus(status,customerId);
	}

	@Override
	public List<Customer> getAllTrue() {
		return customerDao.getAllTrue();
	}

	@Override
	public List<Customer> getAllFalse() {
		return customerDao.getAllFalse();
	}

	@Override
	public void delete(Customer entity) {
		
		
	}

	@Override
	public Result update(Customer entity) {
		boolean result=BusinessRules.CustomerRules.checkTcIfInDatabase(customerDao, entity.getNationalityId());
		if(!result) {
			customerDao.save(entity);
			return new Result("Kisi guncellendi.",true);
		}
		return new Result("Bu kisi zaten veritabaninda mevcut",false);

		
	}

	@Override
	public void deleteById(int id) {
		customerDao.deleteById(id);
		
	}

	@Override
	public Customer getById(int id) {
		return customerDao.getById(id);
	}

	

	

}
