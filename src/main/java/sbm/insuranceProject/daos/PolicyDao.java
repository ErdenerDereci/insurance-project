package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Policy;

@Repository
public interface PolicyDao extends JpaRepository<Policy, Integer> {

}
