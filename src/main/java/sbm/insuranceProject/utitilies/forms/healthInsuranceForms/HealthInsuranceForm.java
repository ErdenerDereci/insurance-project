package sbm.insuranceProject.utitilies.forms.healthInsuranceForms;

import lombok.Data;

@Data
public class HealthInsuranceForm {
    private int id;
    private String customerName;
    private String customerSurname;
    private String nationalityId;
    private int height;
    private int weight;
    private String illnesses;
    private int price;
    private int discountRate;
    private int discountedPrice;
}
