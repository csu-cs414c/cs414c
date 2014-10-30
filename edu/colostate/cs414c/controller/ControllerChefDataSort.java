package edu.colostate.cs.cs414c.controller;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ControllerChefDataSort extends DefaultTableModel {
	//final ControllerChefDataSort model = new ControllerChefDataSort(data, columnNames);
	public ControllerChefDataSort(Object[][] data, String[] columnNames) {
		super(data, columnNames);
	}
	
	public ControllerChefDataSort() {
		// TODO Auto-generated constructor stub
	}

	public Class<?> getColumnClass(int columnIndex) {
	      if (columnIndex == 1) {
	         return Boolean.class;
	      }
	      return super.getColumnClass(columnIndex);
	}
	
	
	
	

}
