package sbm.insuranceProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sbm.insuranceProject.services.CustomerIllnessService;
import sbm.insuranceProject.services.CustomerService;
import sbm.insuranceProject.services.HealthInsuranceService;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessDto;
import sbm.insuranceProject.utitilies.forms.CustomerIllnessForm;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    CustomerIllnessService customerIllnessService;
    @Autowired
    HealthInsuranceService healthInsuranceService;
    @Autowired
    CustomerService customerService;
    @GetMapping("/test")
    public String test(){
       healthInsuranceService.mapHealthInsuranceForm(healthInsuranceService.getById(31));
       return null;
    }

}
