package sbm.insuranceProject.utitilies.helpers;

import sbm.insuranceProject.models.Illness;
import sbm.insuranceProject.utitilies.forms.earthInsuranceForms.EarthquakeInsuranceForm;
import sbm.insuranceProject.utitilies.forms.trafficInsuranceForms.TrafficInsuranceForm;
import sbm.insuranceProject.utitilies.helpers.entities.PriceProps;

import java.util.List;

public class Helpers {

	public static class HealthInsuranceHelper {
		
		private int price=20000;
		
		//Price
		private int getPrice(int height, int weight, List<Illness> illnesses) {
			
			float bmi=getBodyMassIndex(height, weight);
			int calculatedPrice=price;
			if(bmi>40) {
				calculatedPrice = calculatedPrice+5000;
			}else if(bmi>18.5 && bmi<24.5) {
				calculatedPrice = calculatedPrice+2000;
			}else {
				calculatedPrice = calculatedPrice+3500;
			}
			for (Illness illness:illnesses) {
				if(illness.getName().equals("Diyabet")){
					calculatedPrice = calculatedPrice+3000;
				}
				if(illness.getName().equals("Kalp Hastaligi")){
					calculatedPrice = calculatedPrice+4000;
				}
				if(illness.getName().equals("Verem")){
					calculatedPrice = calculatedPrice+6000;
				}
			}
			return calculatedPrice;
		}
		private int getDiscountRate(int height,int weight,List<Illness> illnesses) {
			float bmi=getBodyMassIndex(height, weight);
			int discountRate=10;
			if(bmi>40) {
				discountRate = 15;
			}else if(bmi>18.5 && bmi<24.5) {
				discountRate = 20;
			}else if(bmi>24.5) {
				discountRate=13;
			}

			for (Illness illness:illnesses) {
				if(illness.getName().equals("Diyabet")){
					discountRate=discountRate+5;
				}
				if(illness.getName().equals("Kalp Hastaligi")){
					discountRate=discountRate+3;
				}
				if(illness.getName().equals("Verem")){
					discountRate=discountRate+4;
				}
			}
			return discountRate;
		}
		private int getDiscountedPrice(int pricee,int discountRate) {
			return pricee*(100-discountRate)/100;
		}
		public PriceProps getPrices(int height,int weight,List<Illness> illnesses){
			int price = getPrice(height, weight, illnesses);
			int discountRate= getDiscountRate(height, weight, illnesses);
			int discountedPrice = getDiscountedPrice(price,discountRate);
			PriceProps prices = new PriceProps(price,discountRate,discountedPrice);
			return  prices;
		}
		private float getBodyMassIndex(float height,float weight) {
			float heightx=height/100;
			heightx=heightx*heightx;
			float bmi=weight/heightx;
			
			return bmi;
		}
		
	}
	public static class EarhquakeInsuranceHelper {

		private static int price=20000;
		//Price
		private static int getPrice(EarthquakeInsuranceForm earthquakeInsuranceForm) {

			int calculatedPrice= price;
			int floorCount = earthquakeInsuranceForm.getFloorCount();
			int builtYear = earthquakeInsuranceForm.getBuiltYear();
			String damage = earthquakeInsuranceForm.getBuiltType();
			String builtType= earthquakeInsuranceForm.getBuiltType();
			if (floorCount<5){
				calculatedPrice+=2000;
			}else if(floorCount<10){
				calculatedPrice+=4000;
			}else if(floorCount<20){
				calculatedPrice+=6000;
			}else{
				calculatedPrice+=8000;
			}
			if (builtYear>2017){
				calculatedPrice+=6000;
			}else if(builtYear>2010){
				calculatedPrice+=10000;
			}else if(builtYear>2005){
				calculatedPrice+=15000;
			}else{
				calculatedPrice+=20000;
			}
			if (damage.equals("Agir Hasar")){
				calculatedPrice+=10000;
			}else if(damage.equals("Hafif Hasar")){
				calculatedPrice+=10000;
			}
			if (builtType.equals("Beton")){
				calculatedPrice-=5000;
			}else if(builtType.equals("Tahta")){
				calculatedPrice+=10000;
			}

			return calculatedPrice;
		}
		private static int getDiscountRate(EarthquakeInsuranceForm earthquakeInsuranceForm) {

			int disCountRate=0;
			int floorCount = earthquakeInsuranceForm.getFloorCount();
			int builtYear = earthquakeInsuranceForm.getBuiltYear();
			String damage = earthquakeInsuranceForm.getBuiltType();
			String builtType= earthquakeInsuranceForm.getBuiltType();
			if (floorCount<5){
				disCountRate+=2;
			}else if(floorCount<10){
				disCountRate+=4;
			}else if(floorCount<20){
				disCountRate+=6;
			}else{
				disCountRate+=10;
			}
			if (builtYear>2017){
				disCountRate+=4;
			}else if(builtYear>2010){
				disCountRate+=5;
			}else if(builtYear>2005){
				disCountRate+=7;
			}else{
				disCountRate+=9;
			}
			if (damage.equals("Agir Hasar")){
				disCountRate+=9;
			}else if(damage.equals("Hafif Hasar")){
				disCountRate+=10;
			}
			if (builtType.equals("Beton")){
				disCountRate+=4;
			}else if(builtType.equals("Tahta")){
				disCountRate+=13;
			}
			return disCountRate;
		}
		private static int getDiscountedPrice(int pricee,int discountRate) {
			return pricee*(100-discountRate)/100;
		}
		public static PriceProps getPrices(EarthquakeInsuranceForm earthquakeInsuranceForm){
			int price = getPrice(earthquakeInsuranceForm);
			int discountRate= getDiscountRate(earthquakeInsuranceForm);
			int discountedPrice = getDiscountedPrice(price,discountRate);
			PriceProps prices = new PriceProps(price,discountRate,discountedPrice);
			return  prices;
		}

	}
	public static class TrafficInsuranceHelper {

		private static int price=20000;
		//Price
		private static int getPrice(TrafficInsuranceForm trafficInsuranceForm) {

			int calculatedPrice= price;
			int carAge = trafficInsuranceForm.getAge();
			int dmgGrade = trafficInsuranceForm.getLastYearsDamageGrade();
			String brand = trafficInsuranceForm.getBrand();
			String trafficDensity = trafficInsuranceForm.getCityTrafficDensity();

			if (carAge<5){
				calculatedPrice+=2000;
			}else if(carAge<10){
				calculatedPrice+=4000;
			}else if(carAge<20){
				calculatedPrice+=6000;
			}else{
				calculatedPrice+=8000;
			}
			if (dmgGrade>90){
				calculatedPrice+=3000;
			}else if(dmgGrade>60){
				calculatedPrice+=10000;
			}else if(dmgGrade>40){
				calculatedPrice+=15000;
			}else{
				calculatedPrice+=20000;
			}
			if (brand.equals("BWM")){
				calculatedPrice+=10000;
			}else if(brand.equals("MERCEDES")){
				calculatedPrice+=10000;
			}else{
				calculatedPrice+=15000;
			}
			if (trafficDensity.equals("NORMAL")){
				calculatedPrice-=5000;
			}else if(trafficDensity.equals("YOGUN")){
				calculatedPrice+=10000;
			}

			return calculatedPrice;
		}
		private static int getDiscountRate(TrafficInsuranceForm trafficInsuranceForm) {

			int disCountRate=0;

			int carAge = trafficInsuranceForm.getAge();
			int dmgGrade = trafficInsuranceForm.getLastYearsDamageGrade();
			String brand = trafficInsuranceForm.getBrand();
			String trafficDensity = trafficInsuranceForm.getCityTrafficDensity();
			if (carAge<5){
				disCountRate+=2;
			}else if(carAge<10){
				disCountRate+=4;
			}else if(carAge<20){
				disCountRate+=6;
			}else{
				disCountRate+=10;
			}
			if (dmgGrade>90){
				disCountRate+=4;
			}else if(dmgGrade>60){
				disCountRate+=5;
			}else if(dmgGrade>40){
				disCountRate+=7;
			}else{
				disCountRate+=9;
			}
			if (brand.equals("BWM")){
				disCountRate+=9;
			}else if(brand.equals("MERCEDES")){
				disCountRate+=10;
			}
			if (trafficDensity.equals("NORMAL")){
				disCountRate+=4;
			}else if(trafficDensity.equals("YOGUN")){
				disCountRate+=13;
			}
			return disCountRate;
		}
		private static int getDiscountedPrice(int pricee,int discountRate) {
			return pricee*(100-discountRate)/100;
		}
		public static PriceProps getPrices(TrafficInsuranceForm trafficInsuranceForm){
			int price = getPrice(trafficInsuranceForm);
			int discountRate= getDiscountRate(trafficInsuranceForm);
			int discountedPrice = getDiscountedPrice(price,discountRate);
			PriceProps prices = new PriceProps(price,discountRate,discountedPrice);
			return  prices;
		}

	}
}
