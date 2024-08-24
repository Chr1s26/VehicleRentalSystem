package Dao;

import Model.Rental;

public class RentalDaoImp implements RentalDao {
	
	private static Rental[] rentals = new Rental[1000];
	
	@Override
	public void create(Rental rental) {
		rentals[Rental.getRentCount()-1] = rental;
	}

	@Override
	public Rental findRentalById(int id) {
		for(int i = 0 ; i < Rental.getRentCount(); i++) {
			if(rentals[i].getRentalId() == id) {
				return rentals[i];
			}
		}
		return null;
	}

	@Override
	public Rental[] getAllRental() {
		return rentals;
	}
}
