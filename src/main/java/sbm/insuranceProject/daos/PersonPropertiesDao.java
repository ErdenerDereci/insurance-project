package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.PersonProperties;

@Repository
public interface PersonPropertiesDao extends JpaRepository<PersonProperties, Integer> {

}
