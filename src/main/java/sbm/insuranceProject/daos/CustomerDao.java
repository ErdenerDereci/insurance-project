package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.nationalityId = :nationalityId")
	Customer findByNationalityId(String nationalityId);
	
	@Query(value="SELECT COUNT(*) FROM insurances WHERE insurances.customer_id=:customerId",nativeQuery = true)
	int customerInsuranceCount(int customerId);
}
