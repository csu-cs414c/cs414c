package edu.colostate.cs.cs414c.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.view.SelectMenuView;

public class SelectMenuController{

	private SelectMenuView selectMenuView;
	private Item itemModel;
	
	public SelectMenuController(SelectMenuView selectMenuView, Item itemModel) {
		this.selectMenuView = selectMenuView;
		this.itemModel = itemModel;
		
		selectMenuView.addSelectPizzaListner(new SelectPizzaListner());
		selectMenuView.addSelectDrinkListner(new SelectDrinkListner());
	}
	
	
	class SelectPizzaListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String pizzaSelected = selectMenuView.getPizzaDropDownValue();
			itemModel = new Pizza(pizzaSelected);
			String[] toppings = itemModel.getListOfToppings();
			
			
		}
		
	}
	
	class SelectDrinkListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
}
