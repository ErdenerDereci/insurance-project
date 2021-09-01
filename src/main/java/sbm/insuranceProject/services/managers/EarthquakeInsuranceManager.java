package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.EarthquakeInsuranceDao;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.services.EarthquakeInsuranceService;

@Service
public class EarthquakeInsuranceManager implements EarthquakeInsuranceService{

	@Autowired
	private EarthquakeInsuranceDao earthquakeInsuranceDao;
	
	@Override
	public void add(EarthquakeInsurance earthquakeInsurance) {
		
		earthquakeInsuranceDao.save(earthquakeInsurance);
		
	}

	@Override
	public List<EarthquakeInsurance> getAll() {
		return earthquakeInsuranceDao.findAll();
	}

	

}
