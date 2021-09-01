package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.HealthInsurance;

@Repository
public interface HealthInsuranceDao extends JpaRepository<HealthInsurance, Integer> {

}
