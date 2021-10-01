package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import sbm.insuranceProject.models.EarthquakeInsurance;
import sbm.insuranceProject.models.HealthInsurance;

import java.util.List;

public interface EarthquakeInsuranceDao extends JpaRepository<EarthquakeInsurance, Integer>{
    @Query(value="SELECT count(*) FROM insurances i WHERE i.customer_id=:customerId and i.insurance_type='Earthquake'",nativeQuery = true)
    int checkIfExistsByCustomerId(int customerId);

    @Query("select e from EarthquakeInsurance e inner join Customer c on e.customer.id=c.id where c.status=true")
    List<EarthquakeInsurance> getEarthquakeInsuranceStatusTrue();
}
