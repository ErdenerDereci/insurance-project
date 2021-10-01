package sbm.insuranceProject.utitilies.forms.healthInsuranceForms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.models.Illness;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddHealthInsuranceForm {
    private int id;
    private Customer customer;
    private int weight;
    private int height;
    private List<Illness> illnesses;
    private int price;
    private int discountRate;
    private int discountedPrice;
}
