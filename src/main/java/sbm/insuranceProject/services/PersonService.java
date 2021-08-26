package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.models.Person;

public interface PersonService {

	void add(Person person);
	List<Person> getAll();
	
}
