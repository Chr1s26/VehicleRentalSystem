package Dao;

import Model.Customer;

public class CustomerDaoImp implements CustomerDao {
	
	private static Customer[] customers = new Customer[1000];
	
	static {
		customers[Customer.getCount()-1] = new Customer("John Doe");
		customers[Customer.getCount()-1] = new Customer("Jane Smith");
		customers[Customer.getCount()-1] = new Customer("Alice Johnson");
		customers[Customer.getCount()-1] = new Customer("Bob Brown");
		customers[Customer.getCount()-1] = new Customer("Charlie Davis");
	}

	@Override
	public void addCustomer(Customer customer) {
		customers[Customer.getCount()-1] = customer;
	}

	@Override
	public Customer findCustomerByName(String name) {
		for(int i = 0; i < Customer.getCount(); i++) {
			if(customers[i] != null && customers[i].getName().equalsIgnoreCase(name)) {
				return customers[i];
			}
		}
		return null;
	}

	@Override
	public Customer[] getAllCustomer() {
		return customers;
	}

	

}
