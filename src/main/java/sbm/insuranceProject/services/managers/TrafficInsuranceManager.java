package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.TrafficInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.TrafficInsuranceService;

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
	public void add(TrafficInsurance trafficInsurance) {
		
		trafficInsuranceDao.save(trafficInsurance);
		
	}

	

	@Override
	public List<TrafficInsurance> getAll() {
		return trafficInsuranceDao.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerService.getAll();
	}

	

}
