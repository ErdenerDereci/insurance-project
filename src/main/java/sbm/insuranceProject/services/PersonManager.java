package sbm.insuranceProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbm.insuranceProject.daos.PersonDao;
import sbm.insuranceProject.models.Person;

@Service
public class PersonManager implements PersonService{

	@Autowired
	private PersonDao personDao;
	
	@Override
	public void add(Person person) {
		
		personDao.save(person);
		
	}

	@Override
	public List<Person> getAll() {
		return personDao.findAll();
	}

	

}
