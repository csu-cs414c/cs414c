/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.colostate.cs414c.model.Item;
import edu.colostate.cs414c.view.DefineMenuView;

 
public class DefineMenuController 
{
	private DefineMenuView defineMenuView;
	//private Menu theModel;
	private String user;
	private String action = "none";
		
	public DefineMenuController(String user)
	{
		this.user=user;
		//this.theModel = Menu.getInstance();
		this.defineMenuView = new DefineMenuView();
		this.defineMenuView.buttonListener(new DefineMenuActionListener());
		
	}

	public void showAddMenu(String action){
	defineMenuView.getItemType().setVisible(false);
	defineMenuView.addItemType(action);
	defineMenuView.getItemType().setVisible(true);
	defineMenuView.getNameLabel().setVisible(true);
    	defineMenuView.getNameTextField().setVisible(true);
    	defineMenuView.getPriceLabel().setVisible(true);
    	defineMenuView.getPriceTextField().setVisible(true);
    	defineMenuView.getAddButton().setVisible(true);
    	defineMenuView.getFinish().setVisible(true);
	}
	
	public void addNameAndPrice()
	{
		String name = defineMenuView.getNameTextField().getText();
    	boolean flag = true;
    	float price=0;
		try
		{
			price = Float.parseFloat(defineMenuView.getPriceTextField().getText());
		}
		catch(NumberFormatException e)
		{
			flag = false;
		}
    	
    	if(name.equals("") || flag==false )
    	{
    		JOptionPane.showMessageDialog(null,"Invalid inputs given..!!!");
    	}
    	
    	Item menuItemInfo = new Item() {

                    @Override
                    public float calculateItemPrice() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
    	menuItemInfo.setName(name);
    	menuItemInfo.setPrice(price);
    	
    	//theModel.addElement(menuItemInfo,action);
	}
	
	class DefineMenuActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton tempButton = (JButton)e.getSource();
		    			
			if(tempButton.equals(defineMenuView.getPizzaSizeButton()))
	        {
				action= "Pizza Size";
				showAddMenu(action);
	        }
	        else if(tempButton.equals(defineMenuView.getPizzaTypeButton())) 
	        {
	        	action="Pizza Crust";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(defineMenuView.getPizzaToppingButton())) 
	        {
	        	action="Pizza Topping";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(defineMenuView.getAddonsButton())) 
	        {
	        	action="Addons";
	        	showAddMenu(action);
	        }
	       /* else if(tempButton.equals(defineMenuView.getBreadstickTypeButton())) 
	        {
	        	action="Breadstick Type";
	        	showAddMenu(action);
	        }*/
	      else if(tempButton.equals(defineMenuView.getDrinkButton())) 
	        {
	        	action="Drink";
	        	showAddMenu(action);
	        }
	      /*  else if(tempButton.equals(defineMenuView.getDrinkTypeButton())) 
	        {
	        	action="Drink Type";
	        	showAddMenu(action);
	        }*/
	        else if(tempButton.equals(defineMenuView.getFinish())) 
	        {
	        	if(!defineMenuView.getNameTextField().getText().equals("")){
	        		addNameAndPrice();
	        	}
	        	defineMenuView.getNameTextField().setText("");
	        	defineMenuView.getPriceTextField().setText("");
	        	defineMenuView.getItemType().setVisible(false);
	        	defineMenuView.getNameLabel().setVisible(false);
	        	defineMenuView.getNameTextField().setVisible(false);
	        	defineMenuView.getPriceLabel().setVisible(false);
	        	defineMenuView.getPriceTextField().setVisible(false);
	        	defineMenuView.getAddButton().setVisible(false);
	        	defineMenuView.getFinish().setVisible(false);
	        }
	        else if(tempButton.equals(defineMenuView.getAddButton())) 
	        {
	        	addNameAndPrice();
	        	defineMenuView.getNameTextField().setText("");
	        	defineMenuView.getPriceTextField().setText("");
	        }
	        else if(tempButton.equals(defineMenuView.getBackButton())) 
	        {
	        	defineMenuView.setVisible(false);
	        	new ManagerController(user);
	        }
		}
	}
        
          public static void main(String args[])  {
            new DefineMenuController("manager");
        }
} 

