/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.view;

/**
 *
 * @author pavithra
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DefineMenuView extends JFrame 
{
	private JPanel panel = new JPanel();
	private JLabel welcomeLabel = new JLabel("Define Menu");
	private JLabel pizzaLabel = new JLabel("Pizaa");
	private JButton pizzaSizeButton = new JButton("Pizza Size");
	private JButton pizzaTypeButton = new JButton("Pizza Crust");
	private JButton pizzaToppingButton = new JButton("Pizza Toppings");
	private JLabel addons = new JLabel("Addons");
	private JButton addonsButton = new JButton("Addons");
	//private JButton breadstickTypeButton = new JButton("BreadStick Type");
	private JLabel drinkLabel = new JLabel("Drink");
	private JButton drinkButton = new JButton("Drinks");
	//private JButton drinkTypeButton = new JButton("Drink List");
	private JLabel itemType= new JLabel("");;
	private JLabel nameLabel = new JLabel("Name");
	private JLabel priceLabel = new JLabel("Price");
	private JTextField nameTextField = new JTextField();
	private JTextField priceTextField = new JTextField();
	private JButton addMoreButton = new JButton("Add item");
	private JButton finish = new JButton("Finish");
	
	private JButton back = new JButton("Home");
	
	
	public DefineMenuView() 
	{
		this.setUp();
       	
	}
	
	public void setUp(){
		panel.setLayout(null);
		welcomeLabel.setBounds(200,30,150,25);
		panel.add(welcomeLabel);
		
        pizzaLabel.setBounds(30,100,100,25);
        panel.add(pizzaLabel);
        
        pizzaSizeButton.setBounds(100,100,150,25);
        panel.add(pizzaSizeButton);

        pizzaTypeButton.setBounds(260,100,150,25);
        panel.add(pizzaTypeButton);
        
        pizzaToppingButton.setBounds(420,100,150,25);
        panel.add(pizzaToppingButton);


        addons.setBounds(30,150,100,25);
        panel.add(addons);
        
        addonsButton.setBounds(200,150,150,25);
        panel.add(addonsButton);
        
      
        drinkLabel.setBounds(30,200,100,25);
        panel.add(drinkLabel);
        
        drinkButton.setBounds(200,200,150,25);
        panel.add(drinkButton);

      
        nameLabel.setBounds(30,350,100,25);
        panel.add(nameLabel);
        
        nameTextField.setBounds(200,350,100,25);
        panel.add(nameTextField);
		
        priceLabel.setBounds(30,400,100,25);
        panel.add(priceLabel);
        
        priceTextField.setBounds(200,400,100,25);
        panel.add(priceTextField);
        
        addMoreButton.setBounds(30,450,150,20);
        panel.add(addMoreButton);
        finish.setBounds(200,450,150,20);
        panel.add(finish);
		back.setBounds(200,570,150,25);
		panel.add(back);

		nameLabel.setVisible(false);
    	nameTextField.setVisible(false);
    	priceLabel.setVisible(false);
    	priceTextField.setVisible(false);
    	addMoreButton.setVisible(false);
    	finish.setVisible(false);
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,700);
        this.setVisible(true);
		this.add(panel);
	}
	
	

	public void buttonListener(ActionListener listenerForButton)
	{
    	pizzaSizeButton.addActionListener(listenerForButton);
    	pizzaTypeButton.addActionListener(listenerForButton);
    	pizzaToppingButton.addActionListener(listenerForButton);
    	addonsButton.addActionListener(listenerForButton);
    
    	drinkButton.addActionListener(listenerForButton);
    	
    	addMoreButton.addActionListener(listenerForButton);
    	finish.addActionListener(listenerForButton);
    	back.addActionListener(listenerForButton);
	}
	
			
	public void addItemType(String action){
		itemType = new JLabel(action);
		itemType.setBounds(30,310,200,25);
		panel.add(itemType);
		panel.revalidate();
		panel.repaint();
	}
	
	public JLabel getItemType() {
		return itemType;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBackButton() {
		return back;
	}

	

		
	public JButton getPizzaSizeButton() {
		return pizzaSizeButton;
	}

	public JButton getPizzaTypeButton() {
		return pizzaTypeButton;
	}

	public JButton getPizzaToppingButton() {
		return pizzaToppingButton;
	}

	public JButton getAddonsButton() {
		return addonsButton;
	}

	/*public JButton getBreadstickTypeButton() {
		return breadstickTypeButton;
	}*/

	public JButton getDrinkButton() {
		return drinkButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getPriceTextField() {
		return priceTextField;
	}
	
	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public JLabel getPizzaLabel() {
		return pizzaLabel;
	}

	public JLabel getAddonsLabel() {
		return addons;
	}

	public JLabel getDrinkLabel() {
		return drinkLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public JButton getAddButton() {
		return addMoreButton;
	}

	public JButton getFinish() {
		return finish;
	}

      
}


