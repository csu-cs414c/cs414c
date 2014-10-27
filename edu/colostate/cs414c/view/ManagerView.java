/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.view;

/**
 *
 * @author pavithra
 */
import javax.swing.*;
import java.awt.event.ActionListener;


public class ManagerView extends JFrame 
{
	private JPanel panel = new JPanel();
	private JLabel message;
	private JButton defineMenuButton = new JButton("Define Menu");
	private JButton modifyMenuButton = new JButton("Modify Menu");
	private JButton setSpecialButton = new JButton("Set Special");
	private JButton viewOrderButton = new JButton("View Orders");	
	private JButton logoutButton = new JButton("Logout");
	
	public ManagerView(String user) 
	{
	panel.setLayout(null);
	message = new JLabel(user);
        message.setLocation(250,20);
        message.setSize(200, 30);
        panel.add(message);
        
        defineMenuButton.setLocation(200, 100);
        defineMenuButton.setSize(150, 30);
        panel.add(defineMenuButton);
        
        modifyMenuButton.setLocation(200, 150);
        modifyMenuButton.setSize(150, 30);
        panel.add(modifyMenuButton);

        setSpecialButton.setLocation(200, 200);
        setSpecialButton.setSize(150, 30);
        panel.add(setSpecialButton);

        viewOrderButton.setLocation(200, 250);
        viewOrderButton.setSize(150, 30);
        panel.add(viewOrderButton);
        
        logoutButton.setLocation(200,300);
        logoutButton.setSize(150, 30);
        panel.add(logoutButton);
        
        panel.setOpaque(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(600,700);
        this.setVisible(true);
	this.add(panel);	
	}
	
	
	public JButton getDefineMenuButton() {
		return defineMenuButton;
	}

	
	public void setDefineMenuButton(JButton defineMenuButton) {
		this.defineMenuButton = defineMenuButton;
	}

	
	public JButton getModifyMenuButton() {
		return modifyMenuButton;
	}

	
	public void setModifyMenuButton(JButton modifyMenuButton) {
		this.modifyMenuButton = modifyMenuButton;
	}

	
	public JButton getSetSpecialButton() {
		return setSpecialButton;
	}

	
	public void setSetSpecialButton(JButton setSpecialButton) {
		this.setSpecialButton = setSpecialButton;
	}

	
	public JButton getViewOrderButton() {
		return viewOrderButton;
	}

	
	public void setViewOrderButton(JButton viewOrderButton) {
		this.viewOrderButton = viewOrderButton;
	}

	
	public JButton getLogoutButton() {
		return logoutButton;
	}

	
	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}

	
	public void ButtonListener(ActionListener listenerForButton)
	{
    	defineMenuButton.addActionListener(listenerForButton);
    	modifyMenuButton.addActionListener(listenerForButton);
    	setSpecialButton.addActionListener(listenerForButton);
    	viewOrderButton.addActionListener(listenerForButton);
    	logoutButton.addActionListener(listenerForButton);
        }
  
}

