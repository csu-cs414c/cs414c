package edu.colostate.cs.cs414c.model;

import java.util.Random;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class SaleLineItem {
	
	private String name;
	private float price;
	private int quantity;
	DbConnection db;

	public int randomfn() {
		int n = 0;
		Random rand = new Random();
		n = rand.nextInt(5000) +1000;
		return n;
		
	}
	
	public SaleLineItem(){
		db = new DbConnection();
	}
	
	
	public SaleLineItem(String name, int quantity, float price){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		db = new DbConnection();
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	
}
