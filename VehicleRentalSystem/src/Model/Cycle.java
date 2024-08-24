package Model;

public class Cycle extends Vehicle {
	
	private static int cycleCount = 0;

	public Cycle(String model, String licenseNumber, double rentalPrice,boolean isAvailable) {
		super("cycle",model, licenseNumber, rentalPrice,isAvailable);
		cycleCount++;
	}

	public static int getCycleCount() {
		return cycleCount;
	}

	public static void setCycleCount(int cycleCount) {
		Cycle.cycleCount = cycleCount;
	}

	@Override
	public String toString() {
		return super.toString() + "]";
	}

	

}
