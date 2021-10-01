package sbm.insuranceProject.services.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerIllnessService;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.forms.customerForms.CustomerIllnessDto;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.AddHealthInsuranceForm;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.HealthInsuranceForm;
import sbm.insuranceProject.utitilies.helpers.Helpers;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

@Service
public class HealthInsuranceManager implements HealthInsuranceService{

	Helpers.HealthInsuranceHelper helper = new Helpers.HealthInsuranceHelper();
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
	public Result add(AddHealthInsuranceForm addHealthInsuranceForm) {

		int customerId=addHealthInsuranceForm.getCustomer().getId();
		
		if(BusinessRules.InsuranceRules.checkIfInsuranceCountCorrect(customerService, customerId)){
			if(BusinessRules.InsuranceRules.checkIfCustomersHealthInsuranceExists(healthInsuranceDao,customerId)) {

				PriceProps prices = helper.getPrices(addHealthInsuranceForm.getHeight(),
						addHealthInsuranceForm.getWeight(), addHealthInsuranceForm.getIllnesses());

				addHealthInsuranceForm.setPrice(prices.getPrice());
				addHealthInsuranceForm.setDiscountRate(prices.getDiscountRate());
				addHealthInsuranceForm.setDiscountedPrice(prices.getDiscountedPrice());


				healthInsuranceDao.save(mapAddHealthInsuranceForm(addHealthInsuranceForm));
				return new Result("Ekleme basarili.",true);
			}
			
		}
		return new Result("Bu kisi zaten bir saglik sigortasina sahip.",false);
		
	}

	@Override
	public Result add(HealthInsurance entity) {
		return null;
	}

	@Override
	public List<HealthInsurance> getAll() {
		return healthInsuranceDao.findAll();
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerService.getAllTrue();
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
	public Result update(HealthInsurance entity) {

		return null;
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
		healthInsuranceForm.setIllnesses(setIllnesses(healthInsurance.getCustomer().getId()));
		return healthInsuranceForm;
	}
	public HealthInsurance mapAddHealthInsuranceForm(AddHealthInsuranceForm addHealthInsuranceForm){
		HealthInsurance healthInsurance = new HealthInsurance(
		);
		healthInsurance.setHeight(addHealthInsuranceForm.getHeight());
		healthInsurance.setWeight(addHealthInsuranceForm.getWeight());
		healthInsurance.setDiscountedPrice(addHealthInsuranceForm.getDiscountedPrice());
		healthInsurance.setPrice(addHealthInsuranceForm.getPrice());
		healthInsurance.setDiscountRate(addHealthInsuranceForm.getDiscountRate());
		healthInsurance.setCustomer(addHealthInsuranceForm.getCustomer());
		healthInsurance.setIllnesses(setIllnesses(addHealthInsuranceForm.getCustomer().getId()));

		return healthInsurance;
	}

	@Override
	public List<HealthInsuranceForm> getAllHealthInsuranceForm() {
		List<HealthInsurance> healthInsurances = healthInsuranceDao.getHealthInsuranceStatusTrue();
		List<HealthInsuranceForm> healthInsuranceForms = new ArrayList<HealthInsuranceForm>();
		for (HealthInsurance healthInsurance : healthInsurances){
			healthInsuranceForms.add(mapHealthInsuranceForm(healthInsurance));
		}
		return healthInsuranceForms;
	}

	private String setIllnesses(int customerId){
		List<CustomerIllnessDto> customerIllnessesForm = customerIllnessService.getCustomerIllnessForms(customerId);
		String illnesses="";
		for (int i=0; i<customerIllnessesForm.size(); i++){
			illnesses= illnesses + customerIllnessesForm.get(i).getIllnessName();
			if(i+1!=customerIllnessesForm.size()){
				illnesses = illnesses +"--";
			}
		}
		return illnesses;
	}
	public List<HealthInsurance> getHealthInsuranceStatusTrue(){
		return healthInsuranceDao.getHealthInsuranceStatusTrue();
	}

}
