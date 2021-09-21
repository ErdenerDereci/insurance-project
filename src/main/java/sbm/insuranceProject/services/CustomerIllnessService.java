package sbm.insuranceProject.services;

import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessDto;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessForm;

import java.util.List;

public interface CustomerIllnessService extends ServiceBase<CustomerIllness> {
    List<CustomerIllness> getByCustomerId(int customerId);
    List<CustomerIllnessDto> getCustomerIllnessForms(int customerId);
}
