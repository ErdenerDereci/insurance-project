package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.TrafficInsurance;

@Repository
public interface TrafficInsuranceDao extends JpaRepository<TrafficInsurance, Integer> {

}
