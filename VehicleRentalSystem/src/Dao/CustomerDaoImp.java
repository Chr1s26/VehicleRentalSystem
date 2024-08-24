package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import database.ConnectionFactory;
import database.PgsqlConnectionFactory;

public class CustomerDaoImp implements CustomerDao {
	
	private ConnectionFactory connectionFactory;
	
	public CustomerDaoImp() {
		this.connectionFactory = new PgsqlConnectionFactory();
	}
	
	@Override
	public void create(Customer customer) {
		String sql = "INSERT INTO customers (name) VALUES (?)";
		try(Connection connection = this.connectionFactory.createConnection()){
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer findCustomerByName(String name) {
		String sql = "SELECT * FROM customers where name = ?";
		Customer customer = null;
		try(Connection connection = this.connectionFactory.createConnection()){
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				int custId = resultset.getInt("id");
				String custName = resultset.getString("name");
				customer = new Customer(custId, custName);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		String sql = "SELECT * FROM customers";
		List<Customer> customers = new ArrayList<Customer>();
		try(Connection connection = this.connectionFactory.createConnection()){
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				int custId = resultset.getInt("id");
				String custName = resultset.getString("name");
				customers.add(new Customer(custId, custName));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	

}
