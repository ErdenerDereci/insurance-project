package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private int id;

	@Column(name = "policy_name")
	private String name;

	public Policy() {
		
	}
	public Policy(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
