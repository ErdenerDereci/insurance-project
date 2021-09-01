package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.services.HealthInsuranceService;

@Service
public class HealthInsuranceManager implements HealthInsuranceService{

	@Autowired
	private HealthInsuranceDao healthInsuranceDao;
	
	@Override
	public void add(HealthInsurance healthInsurance) {
		
		healthInsuranceDao.save(healthInsurance);
		
	}

	@Override
	public List<HealthInsurance> getAll() {
		return healthInsuranceDao.findAll();
	}

	

}
