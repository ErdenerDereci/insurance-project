package sbm.insuranceProject.utitilies.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerIllnessForm {
    private int customerId;
    private int illnessId;
    private String customerName;
    private String customerSurname;
    private String illnessName;

}
