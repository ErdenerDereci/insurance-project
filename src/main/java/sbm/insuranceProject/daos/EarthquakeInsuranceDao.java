package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import sbm.insuranceProject.models.EarthquakeInsurance;

public interface EarthquakeInsuranceDao extends JpaRepository<EarthquakeInsurance, Integer>{

}
