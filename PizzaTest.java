package edu.colostate.cs.cs414c.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414c.model.AddOn;
import edu.colostate.cs.cs414c.model.DealOfTheDay;
import edu.colostate.cs.cs414c.model.Drink;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.utils.DbConnection;

public class PizzaTest {

	
	DbConnection db;
	
	@Before
	public void setUp() throws Exception {
		db = new DbConnection();
		
	}

	
	@Test
	public void testPizzaToppings() {
		Set<String> toppings = new HashSet<String>();
		toppings.add("Cheese");
		toppings.add("Onion");
		toppings.add("Tomato");
		toppings.add("Pepperoni");
		
		Item pizzaItem = new  Pizza("Pepperoni Pizza");
		Set<String> pizzaToppings = pizzaItem.getListOfToppings();
		
		Assert.assertEquals(toppings, pizzaToppings);
		
	}
	
	@Test
	public void testCalculatePizzaPrice(){
		Item pizzaItem = new Pizza("Pepperoni Pizza");
		float price = pizzaItem.calculateItemPrice();
		Assert.assertEquals(db.getPizzaPrice("Pepperoni Pizza"), price);
		
	}
	
	@Test
	public void testCalculateDrinkPrice(){
		Item drinkItem = new Drink("Fanta","Large");
		float price = drinkItem.calculateItemPrice();
		Assert.assertEquals(db.getDrinkPrice("Large"), price);
	}
	
		
	@Test
	public void testCalculateAddOnPrice(){
		Item addOn = new AddOn("Onion Rings");
		float price = addOn.calculateItemPrice();
		Assert.assertEquals(db.getAddOnPrice("Onion Rings"), price);
		
	}
	
	@Test
	public void testDealOfTheDay(){
		
		Map<String, String> dealofday = new HashMap<String, String>();
		dealofday.put("pizzaname", "Cheese Pizza");
		dealofday.put("drinkname", "Pepsi");
		dealofday.put("addonname", "Bread Stick");
		dealofday.put("price", "14.99");
		
		DealOfTheDay deal = new DealOfTheDay("Deal Of the Day");
		deal.setDealOfDay("Cheese Pizza", "Pepsi", "Bread Stick", 14.99f);
		Map<String, String> dealFromMethod = deal.dealOfTheDay();
		
		Assert.assertEquals(dealofday, dealFromMethod);
	}
	
	@Test
	public void testDeleteDealOfDay(){
		DealOfTheDay deal = new DealOfTheDay("Deal Of the Day");
		deal.setDealOfDay("Cheese Pizza", "Pepsi", "Bread Stick", 14.99f);
		deal.deleteDealOfDay();
		Map<String, String> dealFromMethod = deal.dealOfTheDay();
		
		Assert.assertTrue(dealFromMethod.isEmpty());
	}
	
	@Test
	public void testModifyPizzaPrice(){
		Item pizzaItem = new Pizza("Cheese Pizza");
		
		pizzaItem.modifyPrice("Cheese Pizza", 9.00f);
		float price = db.getPizzaPrice("Cheese Pizza");
		Assert.assertEquals(9.00f, price);
	}
	
	@Test
	public void testModifyDrinkPrice(){
		Item drinkPrice = new Drink("Pepsi","Medium");
		
		drinkPrice.modifyPrice("Pepsi", 1.20f);
		float price = db.getDrinkPrice("Medium");
		Assert.assertEquals(1.20f, price);
	}
	
	

}
