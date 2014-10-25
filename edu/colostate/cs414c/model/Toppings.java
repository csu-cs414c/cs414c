package edu.colostate.cs.cs414c.model;

import edu.colostate.cs.cs414c.persistance.DbConnection;

public class Toppings {
	
	private String name;
	private DbConnection db;
	
	public Toppings(){
		db = new DbConnection();
	}
	
	
	

}
