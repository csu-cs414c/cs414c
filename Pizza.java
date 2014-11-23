package edu.colostate.cs.cs414c.model;

import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class Pizza extends Item{
	
	private String name;
	private DbConnection db;
	private int id;
	private String desc;
	private float price;
	private String size;
	private String crust;
	private Set<String> userSelectedToppings;
	private String userSelectedCrust;
	private String userSelectedSize;
	private int quantity;
	
	
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
	
	public float calculatePizzaPrice(int numberOfCustomerAddedToppings,
			String pizzaBaseSize, String pizzaCrust, int numberOfPizzas) {

		System.out.println("values is "+numberOfCustomerAddedToppings+pizzaBaseSize+pizzaCrust+numberOfPizzas);
		float finalPrice = 0.0f;
		float pizzaSizePrice = db.getPizzaItemsPrice(pizzaBaseSize);
		float pizzaCrustPrice = db.getPizzaItemsPrice(pizzaCrust);
		float totalToppingsPrice = (numberOfCustomerAddedToppings * db
				.getPizzaItemsPrice("Toppings"));

		finalPrice = numberOfPizzas
				* (pizzaSizePrice + pizzaCrustPrice + totalToppingsPrice);
		System.out.println("Final price ---"+ finalPrice);
		return finalPrice;

	}
	
	public String getName(){
		return this.name;
	}
	
	public void setQuanitity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void setUserSelectedToppings(Set<String> userSelectedToppings){
		this.userSelectedToppings = userSelectedToppings;
	}
	
	public Set<String> getUserSelectedToppings(){
		return this.userSelectedToppings;
	}
	
	public void setUserSelectedBase(String userSelectedCrust){
		this.userSelectedCrust = userSelectedCrust;
	}
	
	public String getUserSelectedCrust(){
		return this.userSelectedCrust;
	}
	
	public void setUserSelectedSize(String userSelectedSize){
		this.userSelectedSize = userSelectedSize;
	}
	
	public String getUserSelectedSize(){
		return this.userSelectedSize;
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
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public int getID()	{
		return id;
	}
	
	public void setID(int id)	{
		this.id =id;
	}
	
	public String getSize()	{
		return size;
	}
	
	public void setSize(String size){
		this.size =size;
	}
	
	public String getCrust()	{
		return crust;
	}
	
	public void setCrust(String crust)	{
		this.crust =crust;
	}
	
	public float getPrice()	{
		return price;
	}
	
	public void setPrice(float price){
		this.price =price;
	}
	
	public String getDesc()	{
		return desc;
	}
	
	public void setDesc(String desc)	{
		this.desc =desc;
	}
	@Override
	public void modifyPrice(String item,float price) {
		db.modifyPizzaPrice(item, price);
		
	}

}
