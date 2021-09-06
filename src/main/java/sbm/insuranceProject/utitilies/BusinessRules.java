package sbm.insuranceProject.utitilies;

import sbm.insuranceProject.daos.CustomerDao;
import sbm.insuranceProject.daos.HealthInsuranceDao;
import sbm.insuranceProject.models.Customer;
import sbm.insuranceProject.services.CustomerService;


public class BusinessRules {

	public static class InsuranceRules{
	
		public static boolean checkIfInsuranceCountCorrect(CustomerService customerService,int customerId) {
			int count=customerService.customerInsuranceCount(customerId);
			if(count<10) {
				return true;
			}
			return false;
		}
		public static boolean checkIfCustomersHealthInsuranceExists(HealthInsuranceDao dao,int customerId) {
			int customerCount=dao.checkIfExistsByCustomerId(customerId);
			if(customerCount!=1) {
				return true;
			}
			return false;
		}
		
	}
	
	
	public static class CustomerRules{
		
		public static boolean checkTcIfInDatabase(CustomerDao dao,String nationalityId) {
			Customer customer=dao.findByNationalityId(nationalityId);
			if(customer==null) {
				return false;
			}
			return true;
		}
	
	}
}
