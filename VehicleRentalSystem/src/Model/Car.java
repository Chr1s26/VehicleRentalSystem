package Model;

public class Car extends Vehicle {
	
	private int numOfSeats;
	private static int carCount=0;
	
	public Car(String model, String licenseNumber, double rentalPrice,boolean isAvailable,int numOfSeats) {
		super("car",model, licenseNumber, rentalPrice,isAvailable);
		this.numOfSeats = numOfSeats;
		carCount++;
	}



	public static int getCarCount() {
		return carCount;
	}



	public static void setCarCount(int carCount) {
		Car.carCount = carCount;
	}



	@Override
	public String toString() {
		return super.toString() +" numOfSeats=" + numOfSeats + "]";
	}

}
