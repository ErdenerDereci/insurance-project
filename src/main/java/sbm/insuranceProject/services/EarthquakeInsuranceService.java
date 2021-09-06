package sbm.insuranceProject.services;


import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;

public interface EarthquakeInsuranceService extends ServiceBase<EarthquakeInsurance> {

	List<Customer> getAllCustomers();
	
}
