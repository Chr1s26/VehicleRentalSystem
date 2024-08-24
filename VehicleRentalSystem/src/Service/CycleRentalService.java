package Service;

import Dao.RentalDao;
import Dao.RentalDaoImp;
import Model.Cycle;
import Model.Rental;

public class CycleRentalService implements VehicleSaleReportService {

private RentalDao rentalDao;
	
	public CycleRentalService() {
		rentalDao = new RentalDaoImp();
	}
	
	@Override
	public void displaySaleReport() {
//		System.out.printf("\nMotorCycle Rented : %d",Rental.getMotorCycleRentalCount());
		System.out.printf("\nMotorCycle Remaining : %d",Cycle.getCycleCount());
		System.out.printf("\nRevenue from Motorcycle : %.2f",totalMotorCycleRevenue());}


	public double totalMotorCycleRevenue() {
		double total = 0;
		Rental[] rentalModel = rentalDao.getAllRental();
		for(int i = 0; i < Rental.getRentCount();i++) {
			if(rentalModel[i].getVehicle().getType().equalsIgnoreCase("cycle")) {
				total += rentalModel[i].getTotalPrice();}}
		return total;}

}
