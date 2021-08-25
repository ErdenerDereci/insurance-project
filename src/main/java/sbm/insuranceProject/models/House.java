package sbm.insuranceProject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int customerId;
	private String address;
	private int builtYear;
	private String builtType;
	private int floorCount;
	private String damageStatus;
	
}
