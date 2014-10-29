package edu.colostate.cs.cs414c.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.colostate.cs.cs414c.model.Drink;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.view.DrinkView;
import edu.colostate.cs.cs414c.view.ViewMain;

public class SelectDrinkController {

	/**
	 * @param args
	 */
	private DrinkView drinkView;
	private Item item;
	private JFrame frame;
	private String drinkSelected;
	private JPanel topJPanel;
	
	ViewMain viewMain;
	JTable table;
	ControllerAddSaleLineItem lineItem;
	Set<String> toppings;
	
	public SelectDrinkController(ViewMain viewMain,JTable table){
		
		item = new Drink();
		String[] listOfDrinks = item.getListOfItems();
		drinkView = new DrinkView(listOfDrinks);
		this.topJPanel = drinkView.getPanel();
		
		drinkView.addSelectComboBoxDrinkListner(new SelectDrinkListner());
		drinkView.addSubmitButtonListner(new SelectButtonListner());
		drinkView.addCancelButtonListner(new CancelButtonListner());
		
	}
	
	class SelectDrinkListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = drinkView.getFrame();
			drinkSelected = drinkView.getDrinkDropDownValue();
			topJPanel.add(drinkView.addDrinkPanel());
			topJPanel.setSize(600,700);
			topJPanel.revalidate();
			topJPanel.repaint();
			topJPanel.setVisible(true);
			
		}
		
	}
	
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String drinkName = drinkView.getSizeSelected();
			item = new Drink(drinkSelected,drinkName);
			
			float drinkPrice = item.calculateItemPrice();
			
			System.out.println("Item Price : "+ drinkPrice);
			
			CardLayout cl = (CardLayout) viewMain.getCards().getLayout();
			cl.show(viewMain.getCards(),"Panel 1");
			System.out.println("Name : ----"+ item.getName());
			System.out.println("Item Price --- : "+ item.calculateItemPrice());
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object[]{item.getName(), item.calculateItemPrice(), false});
		}
		
	}
	
	
	class CancelButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = drinkView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
		}
		
	}
	
	
	

}
