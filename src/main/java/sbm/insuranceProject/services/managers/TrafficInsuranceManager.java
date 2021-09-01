package sbm.insuranceProject.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.TrafficInsuranceDao;
import sbm.insuranceProject.models.TrafficInsurance;
import sbm.insuranceProject.services.TrafficInsuranceService;

@Service
public class TrafficInsuranceManager implements TrafficInsuranceService{

	@Autowired
	private TrafficInsuranceDao trafficInsuranceDao;
	
	@Override
	public void add(TrafficInsurance trafficInsurance) {
		
		trafficInsuranceDao.save(trafficInsurance);
		
	}

	@Override
	public List<TrafficInsurance> getAll() {
		return trafficInsuranceDao.findAll();
	}

	

}
