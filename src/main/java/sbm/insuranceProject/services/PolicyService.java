package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.PolicyType;

public interface PolicyService {

	void Add(PolicyType policy);
	List<PolicyType> GetAll();
}
