package sbm.insuranceProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.PolicyDao;
import sbm.insuranceProject.models.Policy;

@Service
public class PolicyManager implements PolicyService {

	@Autowired
	private PolicyDao policyDao;
	
	public void Add(Policy policy) {
		policyDao.save(policy);
	}
	
	public List<Policy> GetAll(){
		return policyDao.findAll();
	}
}
