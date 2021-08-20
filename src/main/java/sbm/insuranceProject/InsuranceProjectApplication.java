package sbm.insuranceProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sbm.insuranceProject.concretes.PolicyManager;
import sbm.insuranceProject.domain.Policy;

@SpringBootApplication
public class InsuranceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProjectApplication.class, args);
		
	}

}
