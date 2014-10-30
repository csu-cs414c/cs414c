package edu.colostate.cs.cs414c.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.colostate.cs.cs414c.model.AddOn;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.view.AddOnView;
import edu.colostate.cs.cs414c.view.ViewMain;

public class SelectAddOnController {
	
	private AddOnView addOnView;
	private Item item;
	private JFrame frame;
	private String addOnSelected;
	
	ViewMain viewMain;
	JTable table;
	
	public SelectAddOnController(ViewMain viewMain,JTable table){
		this.viewMain =viewMain;
		this.table = table;
		item = new AddOn();
		String[] listOfAddons = item.getListOfItems();
		addOnView = new AddOnView(listOfAddons);
		
		addOnView.addSubmitButtonListner(new SelectButtonListner());
		addOnView.addCancelButtonListner(new CancelButtonListner());
		
	}
	
	
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame = addOnView.getFrame();
			String addOnName = addOnView.getAddOnSelected();
			item = new AddOn(addOnName);
			float drinkPrice = item.calculateItemPrice();
			System.out.println("Item Price : "+ drinkPrice);
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
			frame = addOnView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
		}
		
	}
	
	

}
