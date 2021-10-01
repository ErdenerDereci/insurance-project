package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.HealthInsurance;
import sbm.insuranceProject.models.TrafficInsurance;

import java.util.List;

@Repository
public interface TrafficInsuranceDao extends JpaRepository<TrafficInsurance, Integer> {
    @Query(value="SELECT count(*) FROM insurances i WHERE i.customer_id=:customerId and i.insurance_type='Traffic'",nativeQuery = true)
    int checkIfExistsByCustomerId(int customerId);

    @Query("select t from TrafficInsurance t inner join Customer c on t.customer.id=c.id where c.status=true")
    List<TrafficInsurance> getTrafficInsuranceStatusTrue();
}
