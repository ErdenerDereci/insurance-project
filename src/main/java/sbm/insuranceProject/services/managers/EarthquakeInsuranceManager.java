package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.EarthquakeInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.EarthquakeInsuranceService;
import sbm.insuranceProject.utitilies.BusinessRules;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;
import sbm.insuranceProject.utitilies.helpers.Helpers;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

@Service
public class EarthquakeInsuranceManager implements EarthquakeInsuranceService{

	
	private EarthquakeInsuranceDao earthquakeInsuranceDao;
	private CustomerService customerService;
	
	@Autowired
	public EarthquakeInsuranceManager(EarthquakeInsuranceDao earthquakeInsuranceDao, CustomerService customerService) {
		super();
		this.earthquakeInsuranceDao = earthquakeInsuranceDao;
		this.customerService = customerService;
	}

	@Override
	public Result add(EarthquakeInsuranceForm earthquakeInsuranceForm) {
		if(BusinessRules.InsuranceRules.checkIfCustomersEarthquakeInsuranceExists(earthquakeInsuranceDao, earthquakeInsuranceForm.getCustomer().getId())){
			PriceProps prices = Helpers.EarhquakeInsuranceHelper.getPrices(earthquakeInsuranceForm);
			EarthquakeInsurance entity = mapEntityWithForm(earthquakeInsuranceForm);
			entity.setPrice(prices.getPrice());
			entity.setDiscountedPrice(prices.getDiscountedPrice());
			entity.setDiscountRate(prices.getDiscountRate());


			earthquakeInsuranceDao.save(entity);
			return new Result("Ekleme basarili",true);
		}

		return new Result("Bu kisi zaten bir deprem sigortasina sahip.",false);
	}

	@Override
	public Result add(EarthquakeInsurance entity) {
		return null;
	}

	@Override
	public List<EarthquakeInsurance> getAll() {
		return earthquakeInsuranceDao.getEarthquakeInsuranceStatusTrue();
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerService.getAllTrue();
	}

	@Override
	public void delete(EarthquakeInsurance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result update(EarthquakeInsurance entity) {
		return null;
		
	}

	@Override
	public void deleteById(int id) {
		earthquakeInsuranceDao.deleteById(id);
		
	}

	@Override
	public EarthquakeInsurance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private EarthquakeInsurance mapEntityWithForm(EarthquakeInsuranceForm earthquakeInsuranceForm){
		EarthquakeInsurance earthquakeInsurance = new EarthquakeInsurance();
		earthquakeInsurance.setAddress(earthquakeInsuranceForm.getAddress());
		earthquakeInsurance.setCustomer(earthquakeInsuranceForm.getCustomer());
		earthquakeInsurance.setBuiltType(earthquakeInsuranceForm.getBuiltType());
		earthquakeInsurance.setBuiltYear(earthquakeInsuranceForm.getBuiltYear());
		earthquakeInsurance.setDamageStatus(earthquakeInsuranceForm.getDamageStatus());
		earthquakeInsurance.setFloorCount(earthquakeInsuranceForm.getFloorCount());

		return earthquakeInsurance;
	}

	public List<EarthquakeInsurance> getEarthquakeInsuranceStatusTrue(){
		return earthquakeInsuranceDao.getEarthquakeInsuranceStatusTrue();
	}

}
