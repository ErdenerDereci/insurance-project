package sbm.insuranceProject.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sbm.insuranceProject.domain.Policy;

public interface PolicyDao extends JpaRepository<Policy,Integer> {

}
