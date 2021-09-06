package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.EarthquakeInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.EarthquakeInsuranceService;

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
	public void add(EarthquakeInsurance earthquakeInsurance) {
		
		earthquakeInsuranceDao.save(earthquakeInsurance);
		
	}

	@Override
	public List<EarthquakeInsurance> getAll() {
		return earthquakeInsuranceDao.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerService.getAll();
	}

	@Override
	public void delete(EarthquakeInsurance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EarthquakeInsurance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EarthquakeInsurance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
