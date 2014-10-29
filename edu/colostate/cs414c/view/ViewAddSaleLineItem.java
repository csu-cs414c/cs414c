package edu.colostate.cs.cs414c.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;

import edu.colostate.cs.cs414c.controller.ControllerSaleLineItemDataSort;

public class ViewAddSaleLineItem {
	static final JPanel jpanel = new JPanel(new BorderLayout());
	String[] itemlist = { "Cheese Pizza", "BBQ Chicken", "Pepperoni Pizza", "Veggie Pizza", "Drink" };
	JComboBox<String> itemlistCombo = new JComboBox<>(itemlist);
	JToggleButton buttoncancellineitems = new JToggleButton("Cancel Line Items");
	JButton buttonpay = new JButton("Pay");
	JButton buttoncaltotal = new JButton("Total Sale");
	JButton buttonpizza = new JButton("Pizza");
	JButton buttondrinks = new JButton("Drinks");
	JButton buttonnondrinks = new JButton("Non-Drinks");
	JButton buttontotalsale = new JButton("Total");
	JLabel labeldistotalsale = new JLabel("null");
	 String[] columnNames = {"Item Name", "Item Price","Cancel Item"};
     Object[][] data = {};
	
   
    ControllerSaleLineItemDataSort objccds = new ControllerSaleLineItemDataSort(data, columnNames);
    JTable table = new JTable(objccds);
    static final JPanel bottomPanel = new JPanel();
    static final JPanel middlepanel = new JPanel();
    static final JPanel toppanel = new JPanel();
	
	public ViewAddSaleLineItem() {
		jpanel.setPreferredSize(new Dimension(400, 300));
	    bottomPanel.add(buttoncancellineitems);
	    bottomPanel.add(buttonpay);
	    bottomPanel.add(buttontotalsale);
	    bottomPanel.add(labeldistotalsale);
	    //middlepanel.add(buttoncaltotal, BorderLayout.CENTER);
	    toppanel.add(buttonpizza, BorderLayout.WEST);
	    toppanel.add(buttondrinks, BorderLayout.CENTER);
	    toppanel.add(buttonnondrinks, BorderLayout.EAST);
		//jpanel.setPreferredSize(new Dimension(320, 240));
	    jpanel.add(toppanel, BorderLayout.PAGE_START);
	    jpanel.add(new JScrollPane(table), BorderLayout.CENTER);
	    //jpanel.add(middlepanel);	    
	    jpanel.add(bottomPanel, BorderLayout.PAGE_END);
	    System.out.println("Second");
		//table = new JTable(objccds.getModel());
		
		
	}
	
	public ViewAddSaleLineItem(int n) {
		
	}
	
	public void activateListener(ItemListener al) {
		buttoncancellineitems.addItemListener(al);			
	}
	
	public void activateActionListener(ActionListener al) {
		buttonpay.addActionListener(al);		
		buttonpizza.addActionListener(al);
		buttondrinks.addActionListener(al);
		buttonnondrinks.addActionListener(al);
		buttontotalsale.addActionListener(al);
	}
	
	
	
	public JPanel getMainJPanel() {
   	 return jpanel;
    }
	
	public JTable getJTable() {
		return table;
	}
	
	public JComboBox<String> getJComboBox() {
		return this.itemlistCombo;
	}
	
	public ControllerSaleLineItemDataSort getModel() {
		return this.objccds;
	}
	
	public JToggleButton getToggleButton() {
		return this.buttoncancellineitems;
	}
	
	public JButton getBackButton() {
		return this.buttonpay;
	}
	
	public JButton getPizzaButton() {
		return this.buttonpizza;
	}
	
	public JButton getDrinksButton() {
		return this.buttondrinks;
	}
	
	public JButton getNonDrinksButton() {
		return this.buttonnondrinks;
				
	}
	
	public JButton getTotalSaleButton() {
		return this.buttontotalsale;
	}

}

