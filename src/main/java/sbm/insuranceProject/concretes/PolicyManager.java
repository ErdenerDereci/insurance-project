package sbm.insuranceProject.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.abstracts.PolicyDao;
import sbm.insuranceProject.abstracts.PolicyService;
import sbm.insuranceProject.domain.Policy;

@Service
public class PolicyManager implements PolicyService {

	@Autowired
	private PolicyDao policyDao;
	

	public PolicyManager(PolicyDao policyDao) {
		super();
		this.policyDao = policyDao;
	}


	@Override
	public void add(Policy policy) {
		policyDao.save(policy);
		
	}

}
