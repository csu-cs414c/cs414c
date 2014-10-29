package chef;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class ControllerChef {
	ViewChef objvc;
	JTable table;
	JComboBox<String> ordernoCombo;
	ControllerChefDataSort model;
	JToggleButton showMalesButton;
	JButton buttonback;
	final RowFilter<ControllerChefDataSort,Integer> orderfilter;
	 final TableRowSorter<ControllerChefDataSort> sorter;
	
	public ControllerChef() {
		this.objvc = new ViewChef();
		//objvc.activateListener(new ChefListener());
		this.table = objvc.getJTable();
		this.ordernoCombo = objvc.getJComboBox();
		this.model = objvc.getModel();
		this.table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(ordernoCombo));
	    this.sorter = new TableRowSorter<ControllerChefDataSort>(model);
	    this.orderfilter = new RowFilter<ControllerChefDataSort,Integer>() {
	    public boolean include(Entry<? extends ControllerChefDataSort, ? extends Integer> entry) {
	        	 ControllerChefDataSort personModel = entry.getModel();
	            boolean ordercomplete = ((Boolean) personModel.getValueAt(entry.getIdentifier(), 1)).booleanValue();
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
	       objvc.activateListener(new ChefListener());
	       objvc.activateActionListener(new ChefActionListener());
	      
		
	}
	
	public RowFilter<ControllerChefDataSort,Integer> getOrderFilter() {
		return orderfilter; 
	}
	
	public TableRowSorter<ControllerChefDataSort> getSorter() {
		return this.sorter;
	}
	
	class ChefListener implements ItemListener {
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
	
	class ChefActionListener implements ActionListener {
		ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("ActionListener 1");
			JButton button = (JButton)al.getSource();
			if(button.equals(objvc.getBackButton())) {
				System.out.println("inside");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 1");				
				
			} 
			
		}
	}
}
