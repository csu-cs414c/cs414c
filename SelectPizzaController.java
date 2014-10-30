package edu.colostate.cs.cs414c.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.model.SaleLineItem;
import edu.colostate.cs.cs414c.view.PizzaView;
import edu.colostate.cs.cs414c.view.ViewMain;

public class SelectPizzaController {

	/**
	 * @param args
	 */
	
	private PizzaView pizzaView;
	private Item item;
	private JFrame frame;
	private JPanel topPanel;
	
	ViewMain viewMain;
	JTable table;
	ControllerAddSaleLineItem lineItem;
	Set<String> toppings;
		
	public SelectPizzaController(ViewMain viewMain,JTable table){
		this.viewMain = viewMain;
		this.table = table;
		item = new Pizza();
		String[] listOfPizzas = item.getListOfItems();
		pizzaView = new PizzaView(listOfPizzas);
		pizzaView.addSelectComboBoxPizzaListner(new SelectPizzaListner());
		pizzaView.addSubmitButtonListner(new SelectButtonListner());
		pizzaView.addCancelButtonListner(new CancelButtonListner());
	}
	
	class SelectPizzaListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = pizzaView.getFrame();
			topPanel = pizzaView.getPanel();
			//frame.removeAll();
			String pizzaSelected = pizzaView.getPizzaDropDownValue();
			if(pizzaSelected.equals("Build Your Own Pizza")){
				toppings = item.getAllToppings();
			}else{
				item = new Pizza(pizzaSelected);
			}
			toppings = item.getListOfToppings();
			pizzaView.setToppings(toppings);
			
			String base = item.getBase();
			pizzaView.setBase(base);
			
			topPanel.add(pizzaView.addPizzaPanel());
			topPanel.setSize(600,700);
			topPanel.revalidate();
			topPanel.repaint();
			topPanel.setVisible(true);
			
		}
		
	}
	
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame = pizzaView.getFrame();
			int numberOfToppingsAdded = pizzaView.getUserSelectedToppings();
			String changeBase = pizzaView.getUserSelectedBase();
			String size = pizzaView.getUserSelectedSize();
			item.setUserAddedToppings(numberOfToppingsAdded);
			item.setUserAddedCrest(changeBase);
			item.setUserAddedSize(size);
			//saleLineItem.setItem(item);
			
			frame.setVisible(false);
			frame.dispose();
			CardLayout cl = (CardLayout) viewMain.getCards().getLayout();
			cl.show(viewMain.getCards(),"Panel 3");
			System.out.println("Name : ----"+ item.getName());
			System.out.println("Item Price --- : "+ item.calculateItemPrice());
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object[]{item.getName(), item.calculateItemPrice(), false});
			
			
		}
		
	}
	
	
	class CancelButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = pizzaView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
		}
		
	}
	
	
	

}
