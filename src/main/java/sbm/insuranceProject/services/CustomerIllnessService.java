package sbm.insuranceProject.services;

import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.utitilies.forms.customerForms.CustomerIllnessDto;

import java.util.List;

public interface CustomerIllnessService extends ServiceBase<CustomerIllness> {
    List<CustomerIllness> getByCustomerId(int customerId);
    List<CustomerIllnessDto> getCustomerIllnessForms(int customerId);
}
