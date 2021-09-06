package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.Helpers;

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
	public void add(HealthInsurance healthInsurance) {
		
		int customerId=healthInsurance.getCustomer().getId();
		
		if(BusinessRules.InsuranceRules.checkIfInsuranceCountCorrect(customerService, customerId)){
			if(BusinessRules.InsuranceRules.checkIfCustomersHealthInsuranceExists(healthInsuranceDao,customerId)) {
				int price=Helpers.HealthInsuranceHelper.getPrice(healthInsurance.getHeight(),
						healthInsurance.getWeight(), healthInsurance.getIllnesses());
				int discountRate=Helpers.HealthInsuranceHelper.getDiscountRate(healthInsurance.getHeight(),
						healthInsurance.getWeight(), healthInsurance.getIllnesses());
				int discountedPrice = Helpers.HealthInsuranceHelper.getDiscountedPrice(price, discountRate);
				
				healthInsurance.setPrice(price);
				healthInsurance.setDiscountRate(discountRate);
				healthInsurance.setDiscountedPrice(discountedPrice);
				
				healthInsuranceDao.save(healthInsurance);
			}
			
		}
		
		
	}

	@Override
	public List<HealthInsurance> getAll() {
		return healthInsuranceDao.findAll();
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerService.getAll();
	}

	

}
