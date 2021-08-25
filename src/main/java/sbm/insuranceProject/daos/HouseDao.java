package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import sbm.insuranceProject.models.House;

public interface HouseDao extends JpaRepository<House, Integer>{

}
