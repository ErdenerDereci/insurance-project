package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.helpers.Helpers;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

@Service
public class HealthInsuranceManager implements HealthInsuranceService{

	
	private HealthInsuranceDao healthInsuranceDao;
	private CustomerService customerService;
	
	@Autowired
	public HealthInsuranceManager(HealthInsuranceDao healthInsuranceDao, CustomerService customerService) {
		super();
		this.healthInsuranceDao = healthInsuranceDao;
		this.customerService = customerService;
	}

	@Override
	public Result add(HealthInsurance healthInsurance) {
		
		int customerId=healthInsurance.getCustomer().getId();
		
		if(BusinessRules.InsuranceRules.checkIfInsuranceCountCorrect(customerService, customerId)){
			if(BusinessRules.InsuranceRules.checkIfCustomersHealthInsuranceExists(healthInsuranceDao,customerId)) {

				PriceProps prices = Helpers.HealthInsuranceHelper.getPrices(healthInsurance.getHeight(),
						healthInsurance.getWeight(), healthInsurance.getIllnesses());

				healthInsurance.setPrice(prices.getPrice());
				healthInsurance.setDiscountRate(prices.getDiscountRate());
				healthInsurance.setDiscountedPrice(prices.getDiscountedPrice());
				
				healthInsuranceDao.save(healthInsurance);
			}
			
		}
		return null;
		
	}

	@Override
	public List<HealthInsurance> getAll() {
		return healthInsuranceDao.findAll();
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerService.getAll();
	}

	@Override
	public void delete(HealthInsurance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HealthInsurance entity) {
		healthInsuranceDao.save(entity);
		
	}

	@Override
	public void deleteById(int id) {
		healthInsuranceDao.deleteById(id);
		
	}

	@Override
	public HealthInsurance getById(int id) {
		return healthInsuranceDao.getById(id);
	}

	

}
