package Service;

import java.io.IOException;

import Dao.CustomerDao;
import Dao.CustomerDaoImp;
import Dao.RentalDao;
import Dao.RentalDaoImp;
import Dao.VehicleDao;
import Dao.VehicleDaoImp;
import Model.Customer;
import Model.Rental;
import Model.Vehicle;

public class RentalService extends BaseService {
	
	private VehicleDao vehicleDao;
	private CustomerDao customerDao;
	private RentalDao rentalDao;
	private Rental rental;
	   
	public RentalService() {
		vehicleDao = new VehicleDaoImp();
		customerDao = new CustomerDaoImp();
		rentalDao = new RentalDaoImp();
	}

	public void rentVehicle() throws IOException {
		rental = new Rental();
		this.displayCustomer();
		this.selectCustomer();
		this.displayVehicle();
		this.selectVehicle();
		this.selectRentInfo();
		
		this.rentalDao.create(rental);
		System.out.println("do you want to rent another vehicle");
		
		String flag = bufferedReader.readLine();
			if(flag.equalsIgnoreCase("Yes")) {
				this.rentVehicle();
			}
		this.displayRentVehicle();
		}
		
	
	public void displayCustomer() {
		for(Customer customer: this.customerDao.getAllCustomer()) {
			if(customer != null) {
			System.out.println(customer);}
		}
	}
	
	public void selectCustomer() throws IOException {
		System.out.println("Enter the customer name : ");
		String name = bufferedReader.readLine();
		Customer customer = this.customerDao.findCustomerByName(name);
		
		 if (customer != null) {
		        this.rental.setCustomer(customer);
		    } else {
		        System.out.println("Customer not found.");
		        this.selectCustomer();
		    }
	}
	
	public void displayVehicle() throws IOException {
		
		System.out.println("Enter the Vehicle type that you want to rent");
		String type = bufferedReader.readLine();
		Vehicle[] vehicle = vehicleDao.getVehicleByType(type);
		
		for(Vehicle vehicles: vehicle) {
			System.out.println(vehicles);
		}
	}
	
	public void selectVehicle() throws IOException{
		System.out.println("Select the vehicle by Id : ");
		int id = Integer.parseInt(bufferedReader.readLine());
		Vehicle vehicle = vehicleDao.searchVehicleById(id);
		if(vehicle.isAvailable()) {
		vehicle.setAvailable(false);
		this.rental.setVehicle(vehicle);
		}else {
			System.out.println("This vehicle is not available please choose again");
			this.selectVehicle();
		}
	}
	
	public void selectRentInfo() throws IOException{
		System.out.println("Enter the number of days you want to rent");
		double rentdays = Double.parseDouble(bufferedReader.readLine());
		this.rental.setRentDays(rentdays);
		this.calculatetotalPrice();
	}
	
	public void calculatetotalPrice() {
		double total = rental.getVehicle().getRentalPrice() * rental.getRentDays();
		this.rental.setTotalPrice(total);
	}
	
	public void displayRentVehicle() {
		Rental[] rentals = rentalDao.getAllRental();
		for(Rental rental : rentals) {
			if(rental != null) {
			System.out.println(rental);
			System.out.println("Total price is $"+rental.getVehicle().getRentalPrice() * rental.getRentDays());}
		}
	}

}
