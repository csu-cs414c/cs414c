package edu.colostate.cs.cs414c.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DrinkView {

		
	JComboBox<String> drinkComboBox;
	JFrame frame;
	JPanel topJPanel;
	JPanel drinkSizePanel = new JPanel();
	
	JPanel drinkComboBoxPanel = new JPanel(); 
	JButton submitButton =new JButton("Submit");
	JButton cancelButton = new JButton("Cancel");
	
	
	JRadioButton smallDrinkCheckBox = new JRadioButton("Small");
	JRadioButton mediumDrinkCheckBox = new JRadioButton("Medium");
	JRadioButton largeDrinkCheckBox = new JRadioButton("Large");
	ButtonGroup drinkSizeRadioButtonGroup = new ButtonGroup();
	
	Set<JRadioButton> sizeSetRadioButton = new HashSet<JRadioButton>();
	
	JPanel drinkItemPanel = new JPanel(new GridLayout(3, 1));
	
	public DrinkView(String[] listOfDrinks){
		
		frame = new JFrame("Select Drink Items");
		topJPanel = new JPanel();
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		drinkComboBox = new JComboBox<>(listOfDrinks);
		drinkComboBox.setEditable(false);
		drinkComboBoxPanel.add(drinkComboBox);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        
        topJPanel.add(drinkComboBoxPanel);
        topJPanel.add(buttonPanel);
        
        
        frame.add(topJPanel);
        
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
		
	}
	
	public JPanel addDrinkPanel(){
		
		drinkSizeRadioButtonGroup.add(smallDrinkCheckBox);
		drinkSizeRadioButtonGroup.add(mediumDrinkCheckBox);
		drinkSizeRadioButtonGroup.add(largeDrinkCheckBox);
		
		sizeSetRadioButton.add(smallDrinkCheckBox);
		sizeSetRadioButton.add(mediumDrinkCheckBox);
		sizeSetRadioButton.add(largeDrinkCheckBox);
		
		drinkSizePanel.add(smallDrinkCheckBox);
		drinkSizePanel.add(mediumDrinkCheckBox);
		drinkSizePanel.add(largeDrinkCheckBox);
		
		drinkItemPanel.add(drinkSizePanel,BorderLayout.CENTER);
		
		return drinkItemPanel;
		
	}
	
	public String getDrinkDropDownValue(){
		return drinkComboBox.getSelectedItem().toString();
	}
	
	public void addSelectComboBoxDrinkListner(ActionListener pizza){
		drinkComboBox.addActionListener(pizza);
	}
	
	public void addSubmitButtonListner(ActionListener submit){
		submitButton.addActionListener(submit);
	}
	
	public void addCancelButtonListner(ActionListener submit){
		cancelButton.addActionListener(submit);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public JPanel getPanel(){
		return topJPanel;
	}
	
	public String getSizeSelected(){
		Iterator<JRadioButton> iterator = sizeSetRadioButton.iterator();
		while(iterator.hasNext()){
			JRadioButton userSelected = iterator.next();
			if(userSelected.isSelected()){
				return userSelected.getText() ;
			}
		}
		return null;
	}
	
}
