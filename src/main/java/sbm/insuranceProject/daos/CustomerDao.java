package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.nationalityId = :nationalityId")
	Customer findByNationalityId(String nationalityId);
	
	@Query(value="SELECT COUNT(*) FROM insurances WHERE insurances.customer_id=:customerId",nativeQuery = true)
	int customerInsuranceCount(int customerId);

	@Modifying
	@Transactional
	@Query(value = "Update customers set status=:status where id=:customerId",nativeQuery = true)
	void setStatus(boolean status,int customerId);

	@Query(value = "Select * from customers where status=true",nativeQuery = true)
	List<Customer> getAllTrue();

	@Query(value = "Select * from customers where status=false",nativeQuery = true)
	List<Customer> getAllFalse();
}
