package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.PolicyType;

public interface PolicyTypeService {

	void Add(PolicyType policy);
	List<PolicyType> GetAll();
}
