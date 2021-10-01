package sbm.insuranceProject.utitilies.forms.earthInsuranceForms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.utitilies.forms.AbsractInsuranceForm;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarthquakeInsuranceForm extends AbsractInsuranceForm {

    private String address;
    private int builtYear;
    private String builtType;
    private int floorCount;
    private String damageStatus;
}
