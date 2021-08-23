package sbm.insuranceProject.dtos;

public class CustomerPolicyDto {
	
	private int customerId;
	private String customerName;
	private String customerSurname;
	private String customerEmail;
	private String policyName;
	
	public CustomerPolicyDto(int customerId, String customerName, String customerSurname, String customerEmail,
			String policyName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerEmail = customerEmail;
		this.policyName = policyName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
}
