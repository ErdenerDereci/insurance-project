package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.HealthInsurance;

@Repository
public interface HealthInsuranceDao extends JpaRepository<HealthInsurance, Integer> {
	@Query(value="SELECT count(*) FROM insurances i WHERE i.customer_id=:customerId and i.insurance_type='Health'",nativeQuery = true)
	int checkIfExistsByCustomerId(int customerId);


}
