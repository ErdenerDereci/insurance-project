package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessDto;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessForm;

import java.util.List;

@Repository
public interface CustomerIllnessDao extends JpaRepository<CustomerIllness,Integer> {

    @Query("select c from CustomerIllness c where c.customerId=:customerId")
    List<CustomerIllness> getCustomerIllnesses(@Param("customerId")int customerId);
    @Query(value="select customer_id as customerId,illness_id as illnessId,customers.name as customerName,illnesses.name as illnessName from customers,illnesses,customer_illnesses where customers.id=customer_illnesses.customer_id and illnesses.id=customer_illnesses.illness_id and customers.id=:customerId",nativeQuery = true)
    List<CustomerIllnessDto> getCustomerIllnessForm(@Param("customerId")int customerId);
}
