package edu.colostate.cs.cs414c.model;

import edu.colostate.cs.cs414c.persistance.DbConnection;

public class Pizza extends Item{
	
	private String name;
	private DbConnection db;
	
	public Pizza(String name){
		this.name = name;
		db = new DbConnection();
		setListOfToppings(this.getListOfToppings(name));
		setBase(this.getBase(name));
	}

	@Override
	public float calculateItemPrice() {
		
		
		
		return 0;
	}
	
	public String[] getListOfToppings(String pizzaName){
		return db.getListOfToppins(pizzaName);
	}
	
	public String getBase(String pizzaName){
		return db.getBase(pizzaName);
	}

}
