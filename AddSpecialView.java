package edu.colostate.cs.cs414c.view;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddSpecialView {

	
	JComboBox<String> drinkComboBox,pizzaComboBox,addOnComboBox;
	JFrame frame;
	JPanel topJPanel;
	JPanel labelPanel,labelErroPanel;
	
	JPanel drinkComboBoxPanel = new JPanel(); 
	JPanel pizzaComboBoxPanel = new JPanel();
	JPanel addOnComboBoxPanel = new JPanel();
	
	JButton submitButton =new JButton("Submit");
	JButton cancelButton = new JButton("Cancel");
	JButton deleteCurrentSpecial = new JButton("Delete Special");
	
	
	
	public AddSpecialView(String[] listOfPizzas, String[] listOfDrinks,String[] listOfAddOns){
		
		frame = new JFrame("Select Drink Items");
		topJPanel = new JPanel();
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		pizzaComboBox = new JComboBox<>(listOfPizzas);
		pizzaComboBox.setEditable(false);
		pizzaComboBoxPanel.add(pizzaComboBox);
		
		drinkComboBox = new JComboBox<>(listOfDrinks);
		drinkComboBox.setEditable(false);
		drinkComboBoxPanel.add(drinkComboBox);
		
		addOnComboBox = new JComboBox<String>(listOfAddOns);
		addOnComboBox.setEditable(false);
		addOnComboBoxPanel.add(addOnComboBox);
		
		 JPanel buttonPanel = new JPanel();
	     buttonPanel.add(submitButton);
	     buttonPanel.add(cancelButton);
	     buttonPanel.add(deleteCurrentSpecial);
	     
	     topJPanel.add(pizzaComboBoxPanel);
	     topJPanel.add(drinkComboBoxPanel);
	     topJPanel.add(addOnComboBoxPanel);
	     
	     topJPanel.add(buttonPanel);
		
	     frame.add(topJPanel);
	        
	     frame.revalidate();
	     frame.repaint();
	     frame.setVisible(true);
		
	}
	
	public void displayDealOfDay(Map<String, String> dealOfDay,boolean dispalyOrNot){
		labelPanel = new JPanel();
		if(dispalyOrNot){
			Set<String> keyValues = dealOfDay.keySet();
			Iterator<String> itr = keyValues.iterator();
			while(itr.hasNext()){
				String key = itr.next();
				JLabel newLabel = new JLabel(key +" : "+dealOfDay.get(key));
				labelPanel.add(newLabel);
			}
		}
		topJPanel.add(labelPanel);
	}
	
	public void displayErroMessage(String errMessage){
		labelErroPanel = new JPanel();
		System.out.println("message "+errMessage);
		JLabel newJLabel = new JLabel(errMessage);
		labelErroPanel.add(newJLabel);
		topJPanel.add(labelErroPanel);
	}
	
	
	public String getPizzaDropDownValue(){
		return pizzaComboBox.getSelectedItem().toString();
	}
	
	public String getDrinkDropDownValue(){
		return drinkComboBox.getSelectedItem().toString();
	}
	
	public String getAddOnDropDownValue(){
		return addOnComboBox.getSelectedItem().toString();
	}
	
	public void addSelectComboBoxPizzaListner(ActionListener item){
		pizzaComboBox.addActionListener(item);
		drinkComboBox.addActionListener(item);
		addOnComboBox.addActionListener(item);
	}
	
		
	public void addSubmitButtonListner(ActionListener submit){
		submitButton.addActionListener(submit);
	}
	
	public void addDeleteSpecialButton(ActionListener submit){
		deleteCurrentSpecial.addActionListener(submit);
	}
	
	public void deleteCurrentSpecial(ActionListener submit){
		deleteCurrentSpecial.addActionListener(submit);
	}
	
	public void addCancelButtonListner(ActionListener submit){
		cancelButton.addActionListener(submit);
	}
	
	public JPanel getPanel(){
		return topJPanel;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public JComboBox<String> getPizzaDropDown(){
		return this.pizzaComboBox;
	}
	
	public JComboBox<String > getDrinkDropDown(){
		return this.drinkComboBox;
	}
	
	public JComboBox<String> getAddOnDropDown(){
		return this.addOnComboBox;
	}
	
	
}
