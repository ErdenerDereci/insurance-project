package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.TrafficInsurance;

public interface TrafficInsuranceService extends ServiceBase<TrafficInsurance> {
	List<Customer> getAllCustomers();
}
