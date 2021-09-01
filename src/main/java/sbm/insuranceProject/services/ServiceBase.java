package sbm.insuranceProject.services;

import java.util.List;

public interface ServiceBase<T> {

	void add(T person);
	List<T> getAll();
}
