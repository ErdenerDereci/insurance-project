package sbm.insuranceProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policies")
public class Policy {
	@Id
	@GeneratedValue
	@Column(name="policy_id")
	private int Id;
	
	@Column(name="policy_name")
	private String PolicyName;
	
	public Policy(int id, String policyName) {
		super();
		Id = id;
		PolicyName = policyName;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPolicyName() {
		return PolicyName;
	}
	public void setPolicyName(String policyName) {
		PolicyName = policyName;
	}
}
