package edu.colostate.cs.cs414c.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewChefOrderList {
	private JButton buttonchefvieworder = new JButton("View Orders");
	static final JPanel jpanel = new JPanel();
	
	public ViewChefOrderList() {
		jpanel.setPreferredSize(new Dimension(320, 240));
   	 	jpanel.add(buttonchefvieworder);   	 	
        
	}
	
	public ViewChefOrderList(int n) {
		
	}
	
	public void activateListener(ActionListener al){
   	 buttonchefvieworder.addActionListener(al); 	 
   	 
    }
	
	public JButton getChefViewOrderButton() {
		return this.buttonchefvieworder;
	}
	
	public JPanel getMainJPanel() {
		return jpanel;
    }

}
