package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_surname")
	private String surname;
	
	@Column(name = "customer_email")
	private String email;
	
	@Column(name = "customer_age")
	private int age;
	
	@Column(name = "customer_policy_id")
	private int policyId;

	
	public Customer() {
		
	}

	public Customer(int id, String name, String surname, String email, int age, int policyId) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
		this.policyId = policyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
}
