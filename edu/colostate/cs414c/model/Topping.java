/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.model;

import edu.colostate.cs414c.model.Item;

/**
 *
 * @author pavithra
 */
public class Topping extends Item{
  
	private String name;
        private int id;
        private float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
        
        public int getid()  {
            return id;
        }
        public void setid(int id)   {
            this.id = id;
        }
        
        public float getprice() {
            return price;
        }
        
        public void setprice(float price)   {
            this.price = price;
        }

    @Override
    public float calculateItemPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}



