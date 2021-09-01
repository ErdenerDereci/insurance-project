package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Earthquake")
public class EarthquakeInsurance extends Insurance {
	
	@Column(name="address")
	private String address;
	
	@Column(name="built_year")
	private int builtYear;
	
	@Column(name="built_type")
	private String builtType;
	
	@Column(name="floor_count")
	private int floorCount;
	
	@Column(name="damage_status")
	private String damageStatus;
	
}
