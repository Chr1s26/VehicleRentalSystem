package Service;

import Dao.RentalDao;
import Dao.RentalDaoImp;
import Model.Car;
import Model.Rental;

public class CarRentalService implements VehicleSaleReportService  {
	
private RentalDao rentalDao;
	
	public CarRentalService() {
		rentalDao = new RentalDaoImp();
	}
	
	public double totalCarRevenue() {
		double total = 0;
		Rental[] rentalModel = rentalDao.getAllRental();
		for(int i = 0; i < Rental.getRentCount();i++) {
			if(rentalModel[i].getVehicle().getType().equalsIgnoreCase("car")) {
				total += rentalModel[i].getTotalPrice();}}
		return total;}
	
	@Override
	public void displaySaleReport() {
//		System.out.printf("\nCarRented : %d",Rental.getCarRentalCount());
		System.out.printf("\nCarRemaining : %d",Car.getCarCount());
		System.out.printf("\nRevenue from Cars %.2f",totalCarRevenue());
	}

}
