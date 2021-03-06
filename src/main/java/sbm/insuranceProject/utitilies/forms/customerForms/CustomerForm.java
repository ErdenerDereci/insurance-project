package sbm.insuranceProject.utitilies.forms.customerForms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm {
	
	private int id;
	private String name;
	private String surname;
	private String gender;
	private int birthYear;
	private String email;
	private String nationalityId; 
}
