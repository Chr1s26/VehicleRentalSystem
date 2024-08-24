package Dao;

import Model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	Customer findCustomerByName(String name);
	Customer[] getAllCustomer();

}
