/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.view;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CashierView extends JFrame {
	
	private JLabel welcomeLabel;
	private JButton takeOrderButton = new JButton("Take Order");
	private JButton logOutButton = new JButton("Log Out");
	private JButton viewSplButton = new JButton("View Special");
	private JButton viewOrderbutton = new JButton("View Order");
	private String errorMsg = "An unexpected error occured... Please try again";
	
	public CashierView(String cashierName){
		welcomeLabel = new JLabel(cashierName);
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,700);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		addtoPanel(panel);
		this.setVisible(true);
	}

	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(takeOrderButton);
		panel.add(logOutButton);
		panel.add(viewSplButton);
		panel.add(viewOrderbutton);
	}
	public JButton getViewOrderbutton() {
		return viewOrderbutton;
	}

	public void setBounds(){
		welcomeLabel.setBounds(235,150, 300,25);
		takeOrderButton.setBounds(200, 220, 150,25);
		viewSplButton.setBounds(200, 280, 150,25);
		viewOrderbutton.setBounds(200, 340, 150,25);
		logOutButton.setBounds(200, 400, 150,25);
	}
	
	public JButton getTakeOrderButton() {
		return takeOrderButton;
	}

	public JButton getLogOutButton() {
		return logOutButton;
	}

	public JButton getViewSplButton() {
		return viewSplButton;
	}

	public void ButtonListner(ActionListener l){
		takeOrderButton.addActionListener(l);
		logOutButton.addActionListener(l);
		viewSplButton.addActionListener(l);
		viewOrderbutton.addActionListener(l);
	}
	
	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}
	
	public static void main(String args[]){
		new CashierView("Cashier");
	}

}


