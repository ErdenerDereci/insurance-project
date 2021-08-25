package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.PolicyType;

@Repository
public interface PolicyTypeDao extends JpaRepository<PolicyType, Integer> {

}
