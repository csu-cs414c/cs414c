/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzasystem;

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
        
}



