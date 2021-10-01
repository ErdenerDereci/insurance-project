package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;
import sbm.insuranceProject.utitilies.forms.trafficInsuranceForms.TrafficInsuranceForm;

public interface TrafficInsuranceService extends ServiceBase<TrafficInsurance> {

	List<Customer> getAllCustomers();
	Result add(TrafficInsuranceForm trafficInsuranceForm);
	List<TrafficInsurance> getTrafficInsuranceStatusTrue();
}
