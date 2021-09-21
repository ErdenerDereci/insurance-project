package sbm.insuranceProject.services.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerIllnessService;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessDto;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessForm;
import sbm.insuranceProject.utitilies.forms.HealthInsuranceForm;
import sbm.insuranceProject.utitilies.helpers.Helpers;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

@Service
public class HealthInsuranceManager implements HealthInsuranceService{

	
	private HealthInsuranceDao healthInsuranceDao;
	private CustomerService customerService;
	private CustomerIllnessService customerIllnessService;
	@Autowired
	public HealthInsuranceManager(HealthInsuranceDao healthInsuranceDao, CustomerService customerService,CustomerIllnessService customerIllnessService) {
		super();
		this.healthInsuranceDao = healthInsuranceDao;
		this.customerService = customerService;
		this.customerIllnessService = customerIllnessService;
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
	public List<HealthInsuranceForm> getHealthInsuranceForms() {
		return null;
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


	public HealthInsuranceForm mapHealthInsuranceForm(HealthInsurance healthInsurance){
		HealthInsuranceForm healthInsuranceForm = new HealthInsuranceForm();
		healthInsuranceForm.setId(healthInsurance.getId());
		healthInsuranceForm.setCustomerName(healthInsurance.getCustomer().getName());
		healthInsuranceForm.setCustomerSurname(healthInsurance.getCustomer().getSurname());
		healthInsuranceForm.setNationalityId(healthInsurance.getCustomer().getNationalityId());
		healthInsuranceForm.setHeight(healthInsurance.getHeight());
		healthInsuranceForm.setWeight(healthInsurance.getWeight());
		healthInsuranceForm.setPrice(healthInsurance.getPrice());
		healthInsuranceForm.setDiscountedPrice(healthInsurance.getDiscountedPrice());
		healthInsuranceForm.setDiscountRate(healthInsurance.getDiscountRate());
		setIllnesses(healthInsuranceForm,healthInsurance.getCustomer().getId());
		return healthInsuranceForm;
	}

	@Override
	public List<HealthInsuranceForm> getAllHealthInsuranceForm() {
		List<HealthInsurance> healthInsurances = healthInsuranceDao.findAll();
		List<HealthInsuranceForm> healthInsuranceForms = new ArrayList<HealthInsuranceForm>();
		for (HealthInsurance healthInsurance : healthInsurances){
			healthInsuranceForms.add(mapHealthInsuranceForm(healthInsurance));
		}
		return healthInsuranceForms;
	}

	private HealthInsuranceForm setIllnesses(HealthInsuranceForm healthInsuranceForm,int customerId){
		List<CustomerIllnessDto> customerIllnessesForm = customerIllnessService.getCustomerIllnessForms(customerId);
		String illnesses="";
		for (int i=0; i<customerIllnessesForm.size(); i++){
			illnesses= illnesses + customerIllnessesForm.get(i).getIllnessName();
			if(i+1!=customerIllnessesForm.size()){
				illnesses = illnesses +"--";
			}
		}
		healthInsuranceForm.setIllnesses(illnesses);
		return healthInsuranceForm;
	}

}
