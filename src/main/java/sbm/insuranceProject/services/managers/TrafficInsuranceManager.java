package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.TrafficInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.TrafficInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;
import sbm.insuranceProject.utitilies.forms.trafficInsuranceForms.TrafficInsuranceForm;
import sbm.insuranceProject.utitilies.helpers.Helpers;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

@Service
public class TrafficInsuranceManager implements TrafficInsuranceService{

	
	private TrafficInsuranceDao trafficInsuranceDao;
	private CustomerService customerService;
	
	@Autowired
	public TrafficInsuranceManager(TrafficInsuranceDao trafficInsuranceDao, CustomerService customerService) {
		super();
		this.trafficInsuranceDao = trafficInsuranceDao;
		this.customerService = customerService;
	}
	
	@Override
	public Result add(TrafficInsurance trafficInsurance) {
		
		trafficInsuranceDao.save(trafficInsurance);
		return null;
	}

	

	@Override
	public List<TrafficInsurance> getAll() {
		return trafficInsuranceDao.getTrafficInsuranceStatusTrue();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerService.getAllTrue();
	}

	@Override
	public Result add(TrafficInsuranceForm trafficInsuranceForm) {
		if(BusinessRules.InsuranceRules.checkIfCustomersTrafficInsuranceExists(trafficInsuranceDao, trafficInsuranceForm.getCustomer().getId())){
			PriceProps prices = Helpers.TrafficInsuranceHelper.getPrices(trafficInsuranceForm);
			TrafficInsurance entity = mapEntityWithForm(trafficInsuranceForm);
			entity.setPrice(prices.getPrice());
			entity.setDiscountedPrice(prices.getDiscountedPrice());
			entity.setDiscountRate(prices.getDiscountRate());


			trafficInsuranceDao.save(entity);
			return new Result("Ekleme basarili",true);
		}

		return new Result("Bu kisi zaten bir trafik sigortasina sahip.",false);
	}

	@Override
	public void delete(TrafficInsurance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result update(TrafficInsurance entity) {
		return null;
		
	}

	@Override
	public void deleteById(int id) {
		trafficInsuranceDao.deleteById(id);
		
	}

	@Override
	public TrafficInsurance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private TrafficInsurance mapEntityWithForm(TrafficInsuranceForm trafficInsuranceForm){
		TrafficInsurance trafficInsurance = new TrafficInsurance();
		trafficInsurance.setCustomer(trafficInsuranceForm.getCustomer());
		trafficInsurance.setCityTrafficDensity(trafficInsuranceForm.getCityTrafficDensity());
		trafficInsurance.setAge(trafficInsuranceForm.getAge());
		trafficInsurance.setBrand(trafficInsuranceForm.getBrand());
		trafficInsurance.setLastYearsDamageGrade(trafficInsuranceForm.getLastYearsDamageGrade());


		return trafficInsurance;
	}
	public List<TrafficInsurance> getTrafficInsuranceStatusTrue(){
		return trafficInsuranceDao.getTrafficInsuranceStatusTrue();
	}

}
