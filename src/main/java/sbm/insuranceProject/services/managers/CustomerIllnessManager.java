package sbm.insuranceProject.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.CustomerIllnessDao;
import sbm.insuranceProject.models.CustomerIllness;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.CustomerIllnessService;
import sbm.insuranceProject.utitilies.forms.customerForms.CustomerIllnessDto;

import java.util.List;

@Service
public class CustomerIllnessManager implements CustomerIllnessService {

    @Autowired
    private CustomerIllnessDao customerIllnessDao;

    @Override
    public List<CustomerIllness> getByCustomerId(int customerId) {
        return customerIllnessDao.getCustomerIllnesses(customerId);
    }

    @Override
    public List<CustomerIllnessDto> getCustomerIllnessForms(int customerId) {
        return customerIllnessDao.getCustomerIllnessForm(customerId);
    }

    @Override
    public Result add(CustomerIllness entity) {
        customerIllnessDao.save(entity);
        return null;
    }

    @Override
    public List<CustomerIllness> getAll() {
        return null;
    }

    @Override
    public void delete(CustomerIllness entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Result update(CustomerIllness entity) {
        return null;
    }

    @Override
    public CustomerIllness getById(int id) {
        return null;
    }
}
