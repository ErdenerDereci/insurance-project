package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {

}
