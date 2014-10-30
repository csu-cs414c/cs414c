package edu.colostate.cs.cs414c.model;

import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class AddOn extends Item{
	
	private String name;
	private DbConnection db;
	
	public AddOn(String name){
		this.name = name;
		db = new DbConnection();
	}
	
	public AddOn(){
		db = new DbConnection();
	}

	@Override
	public float calculateItemPrice() {
		return db.getAddOnPrice(name);	
	}

	@Override
	public String[] getListOfItems() {
		Set<String> listOfAddOns = db.getListOfAddOn();
		return listOfAddOns.toArray(new String[listOfAddOns.size()]);
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void modifyPrice(String item, float price) {
		db.modifyAddOnPrice(item, price);
		
	}
	
	

}
