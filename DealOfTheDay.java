package edu.colostate.cs.cs414c.model;

import java.util.Map;
import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class DealOfTheDay {
	
	
	private String name;
	private DbConnection db;
	public DealOfTheDay(String name){
		this.name = name;
		db = new DbConnection();
	}
	
	public String getDealOfDayName(){
		return this.name;
	}

	public Map<String, String> dealOfTheDay(){
		return db.getDealOfDay();
	}
	
	public boolean setDealOfDay(String pizzaname,String drinkname,String addonname,float price){
		return db.setDealOfDay(pizzaname, drinkname, addonname, price);
	}
	
	public void deleteDealOfDay(){
		db.deleteDealOfDay();
	}
	
}

