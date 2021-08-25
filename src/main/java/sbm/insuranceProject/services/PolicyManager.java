package sbm.insuranceProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.PolicyTypeDao;
import sbm.insuranceProject.models.PolicyType;

@Service
public class PolicyManager implements PolicyService {

	@Autowired
	private PolicyTypeDao policyDao;
	
	public void Add(PolicyType policy) {
		policyDao.save(policy);
	}
	
	public List<PolicyType> GetAll(){
		return policyDao.findAll();
	}
}
