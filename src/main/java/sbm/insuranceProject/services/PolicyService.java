package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Policy;

public interface PolicyService {

	void Add(Policy policy);
	List<Policy> GetAll();
}
