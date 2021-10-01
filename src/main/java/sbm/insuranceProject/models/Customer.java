package sbm.insuranceProject.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@OneToMany(mappedBy="customer")
	private List<Insurance> insurances;

	@Column(name="status")
	private boolean status;
}
