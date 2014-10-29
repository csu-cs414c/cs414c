package edu.colostate.cs.cs414c.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import edu.colostate.cs.cs414c.model.AddOn;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.view.AddOnView;

public class SelectAddOnController {
	
	private AddOnView addOnView;
	private Item item;
	private JFrame frame;
	private String addOnSelected;
	
	public SelectAddOnController(){
		item = new AddOn();
		String[] listOfAddons = item.getListOfItems();
		addOnView = new AddOnView(listOfAddons);
		
		addOnView.addSubmitButtonListner(new SelectButtonListner());
		addOnView.addCancelButtonListner(new CancelButtonListner());
		
	}
	
	
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String addOnName = addOnView.getAddOnSelected();
			item = new AddOn(addOnName);
			float drinkPrice = item.calculateItemPrice();
			System.out.println("Item Price : "+ drinkPrice);
		}
		
	}
	
	
	class CancelButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = addOnView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
		}
		
	}
	
	public static void main(String[] args){
		new SelectAddOnController();
	}

}
