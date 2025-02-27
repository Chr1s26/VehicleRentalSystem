package Model;

public class Rental {

	private Vehicle vehicle;
	private Customer customer;
	private double rentDays;
	private int rentalId;
	private double totalPrice;
	private static int rentCount = 0;
	
	public Rental(Vehicle vehicle,Customer customer,double rentDays,double totalPrice) {
		this.vehicle = vehicle;
		this.customer = customer;
		this.rentDays = rentDays;
		this.totalPrice = totalPrice;
	}
	
	public Rental() {
		rentCount++;
		this.rentalId = rentCount;
	}

	public static int getRentCount() {
		return rentCount;
	}

	public static void setRentCount(int rentCount) {
		Rental.rentCount = rentCount;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRentDays(double rentDays) {
		this.rentDays = rentDays;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public double getRentDays() {
		return rentDays;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "\n" +vehicle + "\n" + customer + "\n rentDays=" + rentDays + "\n rentalId="
				+ rentalId ;
	}
	
	

}
