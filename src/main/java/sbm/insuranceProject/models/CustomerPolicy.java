package sbm.insuranceProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="policies_customers")
public class CustomerPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "customers_customer_id")
	private int customerId;
	
	@Column(name="policies_policy_id")
	private int policyId;

	public CustomerPolicy() {
		super();
	}

	public CustomerPolicy(int id, int customerId, int policyId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.policyId = policyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
}
