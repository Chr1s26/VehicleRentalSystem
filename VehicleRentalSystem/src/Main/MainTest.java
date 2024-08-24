package Main;

import java.io.IOException;

import Service.RentalService;

public class MainTest {

	public static void main(String[] args) throws IOException {
		
		RentalService rentalService = new RentalService();
		rentalService.rentVehicle();

	}


}
