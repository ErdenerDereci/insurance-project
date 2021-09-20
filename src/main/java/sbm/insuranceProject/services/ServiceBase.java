package sbm.insuranceProject.services;

import java.util.List;

import sbm.insuranceProject.results.Result;

public interface ServiceBase<T> {

	Result add(T entity);
	List<T> getAll();
	void delete(T entity);
	void deleteById(int id);
	void update(T entity);
	T getById(int id);
}
