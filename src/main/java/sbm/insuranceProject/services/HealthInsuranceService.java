package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.AddHealthInsuranceForm;
import sbm.insuranceProject.utitilies.forms.healthInsuranceForms.HealthInsuranceForm;

public interface HealthInsuranceService extends ServiceBase<HealthInsurance> {
	List<Customer> getAllCustomers();
	List<HealthInsuranceForm> getHealthInsuranceForms();
	HealthInsuranceForm mapHealthInsuranceForm(HealthInsurance healthInsurance);
	List<HealthInsuranceForm> getAllHealthInsuranceForm();
	Result add(AddHealthInsuranceForm healthInsurance);
	List<HealthInsurance> getHealthInsuranceStatusTrue();
}
