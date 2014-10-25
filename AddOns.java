/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzasystem;

/**
 *
 * @author pavithra
 */
public class AddOns extends Item{
    
    private String name;
    private int id;
    private float price;
    private String size;
     public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
        
        public void setName(String name)    {
            this.name =name;
        }
        
        public int getID()  {
            return id;
        }
	public void setID(int id) {
		this.id = id;
	}
	public float getCost() {
		return price;
	}
	public void setCost(float cost) {
		this.price = price;
	}
        public float calculatePrice()   {
            price = super.getPrice();
            return price;
        }
    
}
