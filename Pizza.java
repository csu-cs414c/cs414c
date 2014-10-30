package edu.colostate.cs.cs414c.model;

import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class Pizza extends Item{
	
	private String name;
	private DbConnection db;
	
	public Pizza(String name){
		this.name = name;
		db = new DbConnection();
		setListOfToppings(this.getListOfToppings(name));
		setBase(this.getBase(name));
	}
	
	public Pizza(){
		this.name = getCustomizedPizzaName();
		db = new DbConnection();
		setAllToppings(this.getAllToppings());
	}

	@Override
	public float calculateItemPrice() {
		
		float userAddedBasePrice = 0;
		float userAddedToppingsPrice = db.getPizzaItemsPrice("Toppings") * getUserAddedToppings();
		if( (db.getPizzaItemsPrice(this.getBase(this.name))) < db.getPizzaItemsPrice(getUserAddedCrest())){
			userAddedBasePrice = db.getPizzaItemsPrice(getUserAddedCrest()) - db.getPizzaItemsPrice(this.getBase(this.name));
		}
		float userAddedSize = db.getPizzaItemsPrice(getUserAddedSize());
		float getPizzaPrice = db.getPizzaPrice(name);
		float totalPrice = getPizzaPrice + userAddedSize + userAddedToppingsPrice + userAddedBasePrice;
		
		return totalPrice;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Set<String> getListOfToppings(String pizzaName){
		return db.getListOfToppins(pizzaName);
	}
	
	public String getBase(String pizzaName){
		return db.getBase(pizzaName);
	}
	
	public String[] getListOfItems(){
		Set<String> listOfPizzas = db.getListOfPizzas();
		return listOfPizzas.toArray(new String[listOfPizzas.size()]);
	}
	
	public Set<String> getAllToppings(){
		return db.getAllToppings();
	}
	
	public String getCustomizedPizzaName(){
		return "Customzied Pizza";
	}
	
	@Override
	public void modifyPrice(String item,float price) {
		db.modifyPizzaPrice(item, price);
		
	}

}
