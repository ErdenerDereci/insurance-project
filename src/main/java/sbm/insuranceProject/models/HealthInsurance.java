package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Health")
public class HealthInsurance extends Insurance {
	

	@Column(name="height")
	private int height;
	
	@Column(name="weight")
	private int weight;
	
	//ilnesses array halinda olmasi lazim ayarlanacak
	@Column(name="illnesses")
	private String illnesses;
}
