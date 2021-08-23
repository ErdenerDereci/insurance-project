package sbm.insuranceProject.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.dtos.CustomerPolicyDto;
import sbm.insuranceProject.models.CustomerPolicy;

@Repository
public interface CustomerPolicyDao extends JpaRepository<CustomerPolicy, Integer>{
	@Query("SELECT new sbm.insuranceProject.dtos.CustomerPolicyDto(c.id,c.name,c.surname,c.email,p.name) FROM CustomerPolicy pc inner join Customer c on(pc.customerId=c.id) inner join Policy p on (pc.policyId=p.id)")
	List<CustomerPolicyDto> getCustomerWithPolicy();
}
