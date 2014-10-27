package edu.colostate.cs.cs414c.view;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;

public class SelectMenuView{

	/**
	 * @param args
	 */
	JFrame frame;
	String pizzaItems[] = { "Cheese Pizza", "BBQ Chicken", "Pepperoni Pizza", "Veggie Pizza", "Build Your Own Pizza" };
	
	String drinks[] = {"Pepsi","Coke","Mountain Due","Fanta"};
	
	JPanel pizzaItemPanel;
	JPanel drinkSizePanel;
	JPanel sidesPanel, sidesItemPanel;
	JComboBox<String> pizzaComboBox,drinkComboBox;
	JButton submitButton =new JButton("Submit");
	
	JPanel itemComboBoxPane = new JPanel(); 
   
	
	Set<String> toppingsSelected;
	String baseSelected;
	Set<JCheckBox> toppingsNotSelected = new HashSet<JCheckBox>();
	Set<JRadioButton> baseNotSelected = new HashSet<JRadioButton>();
	
	JCheckBox tomatoCheckBox = new JCheckBox("Tomato");
	JCheckBox cheeseCheckBox = new JCheckBox("Cheese");
	JCheckBox onionCheckBox = new JCheckBox("Onion");
	JCheckBox chickenCheckBox = new JCheckBox("Chicken");
	JCheckBox pepperoniCheckBox = new JCheckBox("Pepperoni");
	JCheckBox mushroomCheckBox = new JCheckBox("Mushroom");
	
	
	JRadioButton panCheckBox = new JRadioButton("Pan");
	JRadioButton thinCheckBox = new JRadioButton("Thin Crust");
	JRadioButton handTossedCheckBox = new JRadioButton("Hand Tossed");
	ButtonGroup baseRadioButtonGroup = new ButtonGroup();
	
	JRadioButton size8InchCheckBox = new JRadioButton("8");
	JRadioButton size12InchCheckBox = new JRadioButton("12");
	JRadioButton size14InchCheckBox = new JRadioButton("14");
	ButtonGroup sizeRadioButtonGroup = new ButtonGroup();
	
	Set<JCheckBox> listOfToppings = new HashSet<JCheckBox>();
	Set<JRadioButton> listOfCrust = new HashSet<JRadioButton>();
	Set<JRadioButton> listOfpizzaSize = new HashSet<JRadioButton>();
	
	JPanel toppings = new JPanel(new GridLayout(6, 2));
	JPanel pizzaBase = new JPanel(new GridLayout(6, 2));
	JPanel pizzaSize = new JPanel(new GridLayout(6, 2));
	
	JRadioButton smallDrinkCheckBox = new JRadioButton("Small");
	JRadioButton mediumDrinkCheckBox = new JRadioButton("Medium");
	JRadioButton largeDrinkCheckBox = new JRadioButton("Large");
	ButtonGroup drinkSizeRadioButtonGroup = new ButtonGroup();
	
	Set<JRadioButton> listOfDrinkSize = new HashSet<JRadioButton>();
	
	//JPanel drink = new JPanel(new GridLayout(6,2));
	JPanel drinkSize = new JPanel(new GridLayout(6,2));
	
	public SelectMenuView(){
		
		frame = new JFrame("Select Items");
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		pizzaComboBox = new JComboBox<>(pizzaItems);
        pizzaComboBox.setEditable(false);
        itemComboBoxPane.add(pizzaComboBox);
        
        drinkComboBox = new JComboBox<String>(drinks);
        drinkComboBox.setEditable(false);
        itemComboBoxPane.add(drinkComboBox);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        
        frame.add(itemComboBoxPane,BorderLayout.PAGE_START);
        frame.add(buttonPanel,BorderLayout.PAGE_END);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
	}
   
	public JPanel addDrinkPanel(){
		
		listOfDrinkSize.add(smallDrinkCheckBox);
		listOfDrinkSize.add(mediumDrinkCheckBox);
		listOfDrinkSize.add(largeDrinkCheckBox);
		
		drinkSizeRadioButtonGroup.add(smallDrinkCheckBox);
		drinkSizeRadioButtonGroup.add(mediumDrinkCheckBox);
		drinkSizeRadioButtonGroup.add(largeDrinkCheckBox);
		
		drinkSize.add(smallDrinkCheckBox);
		drinkSize.add(mediumDrinkCheckBox);
		drinkSize.add(largeDrinkCheckBox);
		
		drinkSizePanel = new JPanel();
		drinkSizePanel.add(drinkSize,BorderLayout.CENTER);
		return drinkSizePanel;
		
	}
	
	
	public JPanel addPizzaPanel(){
	
		// Pizza panel
		
		listOfToppings.add(tomatoCheckBox);
		listOfToppings.add(cheeseCheckBox);
		listOfToppings.add(onionCheckBox);
		listOfToppings.add(chickenCheckBox);
		listOfToppings.add(pepperoniCheckBox);
		listOfToppings.add(mushroomCheckBox);
		
		
		
		boolean isPresent = true;
	    for(JCheckBox toppCheckBox:listOfToppings){
	    	for(String toppingSel:getToppings()){
	    		if(toppCheckBox.getText().equals(toppingSel)){
	    			toppCheckBox.setSelected(true);
	    			toppings.add(toppCheckBox,BorderLayout.CENTER);
	    			isPresent = true;
	    			break;
	    		}else{
	    			isPresent = false;
	    		}
	    	}
		  	if(!isPresent){
		       	toppCheckBox.setSelected(false);
		       	toppings.add(toppCheckBox,BorderLayout.CENTER);
		       	toppingsNotSelected.add(toppCheckBox);
		    }
	    }
	       
	    // crust add 
	    
	    listOfCrust.add(panCheckBox);
	    listOfCrust.add(thinCheckBox);
	    listOfCrust.add(handTossedCheckBox);
	    
	    baseRadioButtonGroup.add(panCheckBox);
	    baseRadioButtonGroup.add(thinCheckBox);
	    baseRadioButtonGroup.add(handTossedCheckBox);
	    
	    
	    
	    for(JRadioButton crustCheckBox: listOfCrust){
	      	if(crustCheckBox.getText().equals(baseSelected)){
	       		crustCheckBox.setSelected(true);
	       		pizzaBase.add(crustCheckBox,BorderLayout.CENTER);
	      	}else{
	      		crustCheckBox.setSelected(false);
	      		pizzaBase.add(crustCheckBox,BorderLayout.CENTER);
	      		baseNotSelected.add(crustCheckBox);
	       	}
	    }
	        
	        
	    // size add user input
	    sizeRadioButtonGroup.add(size8InchCheckBox);
	    sizeRadioButtonGroup.add(size12InchCheckBox);
	    sizeRadioButtonGroup.add(size14InchCheckBox);
	    size8InchCheckBox.setSelected(true);
	    
	    listOfpizzaSize.add(size8InchCheckBox);
	    listOfpizzaSize.add(size12InchCheckBox);
	    listOfpizzaSize.add(size14InchCheckBox);
	    
	   
	    
	    pizzaSize.add(size8InchCheckBox,BorderLayout.CENTER);
	    pizzaSize.add(size12InchCheckBox,BorderLayout.CENTER);
	    pizzaSize.add(size14InchCheckBox,BorderLayout.CENTER);
		
	    // adding to the pizza panel
        pizzaItemPanel = new JPanel();
		
        pizzaItemPanel.add(pizzaBase,BorderLayout.EAST);
        pizzaItemPanel.add(toppings,BorderLayout.CENTER);
        pizzaItemPanel.add(pizzaSize,BorderLayout.WEST);
        
        return pizzaItemPanel;
        
	}
	
	
		
	
	public String getPizzaDropDownValue(){
		return pizzaComboBox.getSelectedItem().toString();
	}
	
	public String getDrinkDropDownValue(){
		return drinkComboBox.getSelectedItem().toString();
	}
	

	public void addSelectPizzaListner(ActionListener pizza){
		
		pizzaComboBox.addActionListener(pizza);
	}
	
	public void addSelectDrinkListner(ActionListener drink){
		drinkComboBox.addActionListener(drink);
	}
	
	public void addSubmitListner(ActionListener submit){
		submitButton.addActionListener(submit);
	}
	
	public void setToppings(Set<String> toppingsSelected){
		this.toppingsSelected = toppingsSelected;
		
	}
	
	public Set<String> getToppings(){
		return toppingsSelected;
	}
	
	public void setBase(String baseSelected){
		this.baseSelected = baseSelected;
	}
	
		
	public JFrame getFrame(){
		return frame;
	}
	
		
	public int getUserSelectedToppings(){
		int userSelected = 0;
		Iterator<JCheckBox> iterator = toppingsNotSelected.iterator();
		while(iterator.hasNext()){
			if(iterator.next().isSelected()){
				userSelected ++;
			}
		}
		return userSelected;
	}
	
	public String getUserSelectedBase(){
		Iterator<JRadioButton> iterator = baseNotSelected.iterator();
		while(iterator.hasNext()){
			JRadioButton userSelected = iterator.next();
			if(userSelected.isSelected()){
				System.out.println("User selected base is "+ userSelected.getText());
				return userSelected.getText() ;
			}
		}
		return null;
	}
	
	public String getUserSelectedSize(){
		Iterator<JRadioButton> iterator = listOfpizzaSize.iterator();
		while(iterator.hasNext()){
			JRadioButton userSelected = iterator.next();
			if(userSelected.isSelected()){
				return userSelected.getText() ;
			}
		}
		return null;
	}
	

}
