package sbm.insuranceProject.services;

import java.util.List;

public interface ServiceBase<T> {

	void add(T entity);
	List<T> getAll();
	void delete(T entity);
	void deleteById(int id);
	void update(T entity);
	T getById(int id);
}
