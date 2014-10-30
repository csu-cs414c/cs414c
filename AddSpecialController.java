package edu.colostate.cs.cs414c.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.colostate.cs.cs414c.controller.SelectPizzaController.CancelButtonListner;
import edu.colostate.cs.cs414c.model.AddOn;
import edu.colostate.cs.cs414c.model.DealOfTheDay;
import edu.colostate.cs.cs414c.model.Drink;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.view.AddSpecialView;

public class AddSpecialController {

	private Item item;
	private AddSpecialView specialView;
	private JFrame frame;
	private JPanel topPanel;
	private float itemPrice= 0.0f;
	private DealOfTheDay deal = new DealOfTheDay("Deal Of The day");
	
	public AddSpecialController(){
		item = new Pizza();
		String listOfPizzas[] = item.getListOfItems();
				
		item = new Drink();
		String listOfDrinks[] = item.getListOfItems();
		item = new AddOn();
		String listOfAddOns[] = item.getListOfItems();
		Map<String, String> dealOfday = deal.dealOfTheDay();
		Set<String> items = dealOfday.keySet();
		specialView = new AddSpecialView(listOfPizzas, listOfDrinks, listOfAddOns);
		specialView.displayDealOfDay(dealOfday,true);
		specialView.addSubmitButtonListner(new SelectButtonListner());
		specialView.addDeleteSpecialButton(new DeleteSpecialButtonListner());
		specialView.addCancelButtonListner(new CancelButtonListner());
		
	}
	
		
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = specialView.getFrame();
			topPanel = specialView.getPanel();
			if(deal.dealOfTheDay().isEmpty()){
				System.out.println("Into Here");
				String pizzaName = specialView.getPizzaDropDownValue();
				item = new Pizza(pizzaName);
				itemPrice = itemPrice + item.calculateItemPrice();
				System.out.println(itemPrice);
				
				String drinkName = specialView.getDrinkDropDownValue();
				item = new Drink(drinkName,"Small");
				itemPrice = itemPrice+ item.calculateItemPrice();
				System.out.println(itemPrice);
				
				String addOnName = specialView.getAddOnDropDownValue();
				item = new AddOn(addOnName);
				itemPrice = itemPrice + item.calculateItemPrice();
				System.out.println(itemPrice);
				deal.setDealOfDay(pizzaName, drinkName, addOnName, itemPrice);
				frame.setVisible(false);
				frame.dispose();
			}else{
				System.out.println("Into");
				specialView.displayErroMessage("Delete Existing special and submit New Special");
				frame.setVisible(true);
				
			}
			System.out.println("Total Item price "+ itemPrice);
			
		}
		
	}
	
	class DeleteSpecialButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			frame = specialView.getFrame();
			deal.deleteDealOfDay();
			
			frame.setVisible(false);
			frame.dispose();
			
		}
	}
	
	
	class CancelButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = specialView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
			
		}
	}
	
	public static void main(String[] args){
		new AddSpecialController();
	}
	
}
