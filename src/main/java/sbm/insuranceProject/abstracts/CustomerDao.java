package sbm.insuranceProject.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sbm.insuranceProject.domain.*;
public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
