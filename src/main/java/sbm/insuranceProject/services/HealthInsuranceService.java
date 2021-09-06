package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;

public interface HealthInsuranceService extends ServiceBase<HealthInsurance> {
	List<Customer> getAllCustomers();
}
