package edu.colostate.cs.cs414c.controller;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ControllerSaleLineItemDataSort extends DefaultTableModel {
	//final ControllerChefDataSort model = new ControllerChefDataSort(data, columnNames);
	public ControllerSaleLineItemDataSort(Object[][] data, String[] columnNames) {
		super(data, columnNames);
	}
	
	public ControllerSaleLineItemDataSort() {
		// TODO Auto-generated constructor stub
	}

	public Class<?> getColumnClass(int columnIndex) {
	      if (columnIndex == 2) {
	         return Boolean.class;
	      }
	      return super.getColumnClass(columnIndex);
	}
	
	
	
	

}
