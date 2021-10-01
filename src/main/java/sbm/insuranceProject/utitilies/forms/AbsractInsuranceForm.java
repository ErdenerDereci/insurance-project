package sbm.insuranceProject.utitilies.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sbm.insuranceProject.models.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsractInsuranceForm {

    private int id;
    private Customer customer;


}
