package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
