package edu.colostate.cs.cs414c.model;

import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class Drink extends Item{
	
	private String name;
	private String size;
	private DbConnection db;
	
	public Drink(String name, String size){
		this.name = name;
		this.size = size;
		db = new DbConnection();
		
	}
	
	public Drink(){
		db = new DbConnection();
	}

	@Override
	public float calculateItemPrice() {
		return this.getDrinkPrice(size);
	}

	@Override
	public String[] getListOfItems() {
		Set<String> listOfDrinks = db.getListOfDrinks();
		return listOfDrinks.toArray(new String[listOfDrinks.size()]);
	}
	
	public float getDrinkPrice(String size){
		return db.getDrinkPrice(size);
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void modifyPrice(String item, float price) {
		db.modifydrinkSizePrice(item, price);
		
	}
	

}
