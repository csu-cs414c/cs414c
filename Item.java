package edu.colostate.cs.cs414c.model;

import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public abstract class Item {
	
	
	private String name;
	private Set<String> listOfToppings,listAllToppings;
	private String base;
	
	private int userAddedToppings;
	private String userAddedCrest;
	private String userAddedSize;
	private static DbConnection db;
	
		
	public abstract float calculateItemPrice();
	abstract public String[] getListOfItems();
	abstract public void modifyPrice(String item,float price);
	
		
	public void setListOfToppings(Set<String> listOfToppings){
		this.listOfToppings = listOfToppings;
	}
	
	public String getName(){
		return name;
	}
	
	public Set<String> getListOfToppings(){
		return this.listOfToppings;
	}
	
	public void setBase(String base){
		this.base = base;
	}
	
	public void setAllToppings(Set<String> listAllToppings){
		this.listAllToppings = listAllToppings;
	}
	
	public Set<String> getAllToppings(){
		return this.listAllToppings;
	}
	
	public String getBase(){
		return base;
	}
	
		
	public void setUserAddedToppings(int userAddedToppings){
		this.userAddedToppings = userAddedToppings;
	}
	
	public int getUserAddedToppings(){
		return this.userAddedToppings;
	}
	
	public void setUserAddedCrest(String userAddedCrest){
		this.userAddedCrest = userAddedCrest;
	}
	
	public String getUserAddedCrest(){
		return this.userAddedCrest;
	}
	
	public void setUserAddedSize(String userAddedSize){
		this.userAddedSize = userAddedSize;
	}
	
	public String getUserAddedSize(){
		return this.userAddedSize;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	
	public float getPrice()	{
		return this.getPrice();
	}
	/*
	public static void addItem(Item menuItem,String action) throws SQLException	{
		db = new DbConnection();
		db.addItem(menuItem,action);
	}
	public static void addItem(Pizza menuItem, String description, String action)	throws SQLException	{
		db = new DbConnection();
		db.addItem(menuItem,description,action);
	}*/
	
}
