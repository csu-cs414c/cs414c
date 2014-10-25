package edu.colostate.cs414c.model;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */
public class Pizza {
    
   private String name;
   private int id;
   private String desc;
   private float price;
   private String size;
   private String crust;
   private ArrayList<Topping> toppingslist = new ArrayList<Topping>();
   
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
        }
   public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public float getCost() {
		return price;
	}
	public void setCost(int price) {
		this.price = price;
	}
        
        public String getDesc()  {
            return desc;
        }
        
        public void setDesc(String desc)   {
            this.desc = desc;
        }
	
	public ArrayList<Topping> getToppings()  {
            return toppingslist;
        }
        
        public void setToppings(Topping topping)  {
            toppingslist.add(topping);
        }
        
        public void removeToppings(Topping topping)  {
            toppingslist.remove(topping);
        }
       public float calculatePrice()    {
           price = db.getBasicPrice(String pizza, String size);
           for(Topping t:toppingslist)  {
               price = price + t.getPrice();
           }
           return price;
       }
       
       
      
}


	





