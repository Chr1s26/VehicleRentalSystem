package Dao;

import Model.Rental;

public interface RentalDao {

	void create(Rental rental);
	Rental findRentalById(int id);
	Rental[] getAllRental();

}
