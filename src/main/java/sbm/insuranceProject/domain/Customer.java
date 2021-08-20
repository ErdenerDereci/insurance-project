package sbm.insuranceProject.domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="customer_id")
	private int Id;
	@Column(name="customer_name")
	private String Name;
	@Column(name="customer_surname")
	private String Surname;
	@Column(name="customer_email")
	private String Email;
	@Column(name="customer_age")
	private int Age;
	@Column(name="customer_policy_id")
	private int PolicyId;
	
	public Customer(int id, String name, String surname, String email, int age, int policyId) {
		super();
		Id = id;
		Name = name;
		Surname = surname;
		Email = email;
		Age = age;
		PolicyId = policyId;
	}

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}
}
