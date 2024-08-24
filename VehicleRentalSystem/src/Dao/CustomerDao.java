package Dao;

import java.util.List;

import Model.Customer;

public interface CustomerDao {

	void create(Customer customer);
	Customer findCustomerByName(String name);
	List<Customer> getAllCustomer();

}
