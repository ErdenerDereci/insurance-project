package sbm.insuranceProject.services;


import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;

public interface EarthquakeInsuranceService extends ServiceBase<EarthquakeInsurance> {

	List<Customer> getAllCustomers();
	Result add(EarthquakeInsuranceForm earthquakeInsuranceForm);
	List<EarthquakeInsurance> getEarthquakeInsuranceStatusTrue();
	
}
