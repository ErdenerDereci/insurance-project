package sbm.insuranceProject.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class PolicyType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private int id;

	@Column(name = "policy_name")
	private String name;
	
	@ManyToMany
	private List<Customer> customers;
	public PolicyType() {
		
	}
	public PolicyType(int id, String name) {
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
