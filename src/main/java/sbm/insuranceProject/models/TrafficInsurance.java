package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Traffic")
public class TrafficInsurance extends Insurance{
	

	@Column(name="last_years_damage_grade")
	private int lastYearsDamageGrade;
	
	@Column(name="age")
	private int age;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="city_traffic_density")
	private String cityTrafficDensity;

	
}

