package com.example.client;

import java.util.ArrayList;
import java.util.List;

public class WebPizza {
	 String pizzaitem;
	 String pizzaid;
	 String pizzaquan;
	 String pizzaprice;
	 String pizzabase;
	 List<String> pizzatopping;
	 static List<WebPizza> saleset = new ArrayList<WebPizza>();
	
	public WebPizza(String pizzaid, String pizzaitem, String pizzabase, String pizzaquan, String pizzaprice, List<String> pizzatopping){
		this.pizzaid = pizzaid;
		this.pizzaitem = pizzaitem;
		this.pizzabase = pizzabase;
		this.pizzaquan = pizzaquan;
		this.pizzaprice = pizzaprice;
		this.pizzatopping = pizzatopping;
	}
	
	public String getPizzaID(){
		return this.pizzaid;
	}
	
	public String getPizzaItem(){
		return this.pizzaitem;
	}
	
	public String getPizzaBase(){
		return this.pizzabase;
	}
	
	public String getPizzaQuan(){
		return this.pizzaquan;
	}
	
	public String getpizzaprice(){
		return this.pizzaprice;
	}
	
	public List<String> getPizzaTopping(){
		return this.pizzatopping;
	}
	
	
	public void setPizzaID(String pizzaid){
		this.pizzaid = pizzaid;
	}
	
	public void setPizzaItem(String pizzaitem){
		this.pizzaitem = pizzaitem;
	}
	
	public void setPizzaBase(String pizzabase){
		this.pizzabase = pizzabase;
	}
	
	public void setPizzaQuan(String pizzaquan) {
		this.pizzaquan = pizzaquan;
	}
	
	public void setpizzaprice(String pizzaprice) {
		this.pizzaprice = pizzaprice;
	}
	
	public void setPizzaTopping(List<String> pizzatopping){
		this.pizzatopping = pizzatopping;
	}
}
