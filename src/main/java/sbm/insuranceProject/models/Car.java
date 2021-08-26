package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="owner_id")
	private int ownerId;
	
	@Column(name="last_years_damage_grade")
	private int lastYearsDamageGrade;
	
	@Column(name="age")
	private int age;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="city_traffic_density")
	private String cityTrafficDensity;
}

