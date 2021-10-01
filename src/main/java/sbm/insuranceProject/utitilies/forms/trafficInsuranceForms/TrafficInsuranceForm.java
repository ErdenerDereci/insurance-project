package sbm.insuranceProject.utitilies.forms.trafficInsuranceForms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sbm.insuranceProject.utitilies.forms.AbsractInsuranceForm;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrafficInsuranceForm extends AbsractInsuranceForm {

    private int lastYearsDamageGrade;
    private int age;
    private String brand;
    private String cityTrafficDensity;
}
