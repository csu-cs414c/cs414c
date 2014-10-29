package chef;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ViewChef {
	static final JPanel jpanel = new JPanel(new BorderLayout());
	String[] orderno = { "sd1245", "sd1246", "sd1247", "sd1248", "sd1249" };
	JComboBox<String> ordernoCombo = new JComboBox<>(orderno);
	JToggleButton buttoncompleteorder = new JToggleButton("Complete Order");
	JButton buttonback = new JButton("Back");
	 String[] columnNames = {"Order No.", "Mark Done"};
     Object[][] data = {
         {orderno[0], false},
         {orderno[1], false},
         {orderno[2], false},
         {orderno[3], false},
         {orderno[4], false}
     };
	
   
    ControllerChefDataSort objccds = new ControllerChefDataSort(data, columnNames);
    JTable table = new JTable(objccds);
    static final JPanel bottomPanel = new JPanel();
	
	public ViewChef() {
		jpanel.setPreferredSize(new Dimension(320, 240));
	    bottomPanel.add(buttoncompleteorder);
	    bottomPanel.add(buttonback);
		//jpanel.setPreferredSize(new Dimension(320, 240));
		jpanel.add(new JScrollPane(table), BorderLayout.CENTER);
	    jpanel.add(bottomPanel, BorderLayout.PAGE_END);
	    System.out.println("Second");
		//table = new JTable(objccds.getModel());
		
		
	}
	
	public ViewChef(int n) {
		
	}
	
	public void activateListener(ItemListener al) {
		buttoncompleteorder.addItemListener(al);		
	}
	
	public void activateActionListener(ActionListener al) {
		buttonback.addActionListener(al);		
	}
	
	
	
	public JPanel getMainJPanel() {
   	 return jpanel;
    }
	
	public JTable getJTable() {
		return table;
	}
	
	public JComboBox<String> getJComboBox() {
		return this.ordernoCombo;
	}
	
	public ControllerChefDataSort getModel() {
		return this.objccds;
	}
	
	public JToggleButton getToggleButton() {
		return this.buttoncompleteorder;
	}
	
	public JButton getBackButton() {
		return this.buttonback;
	}

}
