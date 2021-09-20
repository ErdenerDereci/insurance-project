package sbm.insuranceProject.results;

import lombok.Data;

@Data
public class Result {
	
	private String message;
	private boolean success;
	
	public Result(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
}
