package edu.colostate.cs.cs414c.controller;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import edu.colostate.cs.cs414c.controller.SelectPizzaController.SelectButtonListner;
import edu.colostate.cs.cs414c.controller.SelectPizzaController.SelectPizzaListner;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.model.SaleLineItem;
import edu.colostate.cs.cs414c.view.PizzaView;
import edu.colostate.cs.cs414c.view.ViewAddSaleLineItem;
import edu.colostate.cs.cs414c.view.ViewMain;

public class ControllerAddSaleLineItem {
	ViewMain objviewmain;
	ViewAddSaleLineItem objvc;
	JTable table;
	JComboBox<String> ordernoCombo;
	ControllerSaleLineItemDataSort model;
	JToggleButton showMalesButton;
	JButton buttonback;
	final RowFilter<ControllerSaleLineItemDataSort,Integer> orderfilter;
	final TableRowSorter<ControllerSaleLineItemDataSort> sorter;
	
	private PizzaView pizzaView;
	private Item item;
	private JFrame frame;
	private SaleLineItem saleLineItem;
	
	public ControllerAddSaleLineItem(ViewMain objviewmain) {
		this.objviewmain = objviewmain;
		this.objvc = objviewmain.getViewAddSaleLineItem();
		//objvc.activateListener(new ChefListener());
		this.table = objvc.getJTable();
		this.ordernoCombo = objvc.getJComboBox();
		this.model = objvc.getModel();
		this.table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(ordernoCombo));
	    this.sorter = new TableRowSorter<ControllerSaleLineItemDataSort>(model);
	    this.orderfilter = new RowFilter<ControllerSaleLineItemDataSort,Integer>() {
	    public boolean include(Entry<? extends ControllerSaleLineItemDataSort, ? extends Integer> entry) {
	        	 ControllerSaleLineItemDataSort personModel = entry.getModel();
	            boolean ordercomplete = ((Boolean) personModel.getValueAt(entry.getIdentifier(), 2)).booleanValue();
	            if(ordercomplete == false)
	            	ordercomplete = true;
	            else
	            	ordercomplete = false;
	           return ordercomplete;
	          }
	     };
	     
	     System.out.println("first");

	      sorter.setRowFilter(null);
	      table.setRowSorter(sorter);

	       this.showMalesButton = objvc.getToggleButton();
	       this.buttonback = objvc.getBackButton();
	       objvc.activateListener(new addSaleLineItemListener());
	       objvc.activateActionListener(new addSaleLineItemActionListener());
	       System.out.println("Listener now");
	       
	       		
	}
	
	public RowFilter<ControllerSaleLineItemDataSort,Integer> getOrderFilter() {
		return orderfilter; 
	}
	
	public TableRowSorter<ControllerSaleLineItemDataSort> getSorter() {
		return this.sorter;
	}
	
	public JTable getJTable() {
		return this.table;
	}
	
	class addSaleLineItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println("item event");
			if (e.getStateChange() == ItemEvent.SELECTED) {
	               System.out.println("selected!");
	               
	               sorter.setRowFilter(getOrderFilter());
	            } else {
	               sorter.setRowFilter(null);
	            }
			
		}
	}
	
	class addSaleLineItemActionListener implements ActionListener {
		//ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			saleLineItem = new SaleLineItem();
			System.out.println("ActionListener 1");
			JButton button = (JButton)al.getSource();
			if(button.equals(objvc.getPizzaButton())) {
				System.out.println("Pizza");
				new SelectPizzaController(objviewmain,table);
				//DefaultTableModel model = (DefaultTableModel)table.getModel();
				//model.addRow(new Object[]{"Parotta", false});
				//System.out.println("item name is"+saleLineItem.getItem().getBase());
				
				System.out.println("Now");
				
			} else if(button.equals(objvc.getBackButton())) {
				System.out.println("inside");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 1");	
				new SelectDrinkController(objviewmain,table);
				
			} else if(button.equals(objvc.getTotalSaleButton())) {
				for(int i=0; i<table.getRowCount(); i++) {
					boolean isChecked = (Boolean) table.getValueAt(i, 1);
					if(isChecked) {
						String selected = (String) table.getValueAt(i, 0);
						System.out.println(selected);
					}
				}
			}
			
		}
	}
	
		
	
	public void setItem(Item item){
		this.item = item;
	}
	
	public Item getItem(){
		return this.item;
	}
}

