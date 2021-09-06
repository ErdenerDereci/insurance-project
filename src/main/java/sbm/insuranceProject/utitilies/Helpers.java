package sbm.insuranceProject.utitilies;

public class Helpers {

	public static class HealthInsuranceHelper {
		
		private static int price=20000;
		
		//Price
		public static int getPrice(int height,int weight,String illness) {
			
			float bmi=getBodyMassIndex(height, weight);
			int calculatedPrice=price;
			if(bmi>40) {
				calculatedPrice = calculatedPrice+5000;
			}else if(bmi>18.5 && bmi<24.5) {
				calculatedPrice = calculatedPrice+2000;
			}else {
				calculatedPrice = calculatedPrice+3500;
			}
			if(illness.equals("Diyabet") || illness.equals("Kalp Hastaligi")) {
				calculatedPrice = calculatedPrice+3000;
			}
			return calculatedPrice;
		}
		public static int getDiscountRate(int height,int weight,String illness) {
			float bmi=getBodyMassIndex(height, weight);
			int discountRate=10;
			if(bmi>40) {
				discountRate = 15;
			}else if(bmi>18.5 && bmi<24.5) {
				discountRate = 20;
			}else if(bmi>24.5) {
				discountRate=13;
			}
			if(illness.equals("Diyabet") || illness.equals("Kalp Hastaligi")) {
				discountRate=discountRate+5;
			}
			return discountRate;
		}
		public static int getDiscountedPrice(int pricee,int discountRate) {
			return pricee*(100-discountRate)/100;
		}
		private static float getBodyMassIndex(float height,float weight) {
			float heightx=height/100;
			heightx=heightx*heightx;
			float bmi=weight/heightx;
			
			return bmi;
		}
		
	}
}
