package edu.colostate.cs.cs414c.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PizzaView {

	JDialog dialog;
	JComboBox<String> pizzaComboBox;
	JFrame frame;
	JPanel topJPanel;
	
	Set<String> toppingsSelected;
	String baseSelected;
	Set<JCheckBox> toppingsNotSelected = new HashSet<JCheckBox>();
	Set<JRadioButton> baseNotSelected = new HashSet<JRadioButton>();
	
	JPanel pizzaComboBoxPanel = new JPanel(); 
	JButton submitButton =new JButton("Submit");
	JButton cancelButton = new JButton("Cancel");
	JPanel pizzaItemPanel = new JPanel();
	
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
	
	Set<JCheckBox> toppingsSetCheckBox = new HashSet<JCheckBox>();
	Set<JRadioButton> crustSetRadioButton = new HashSet<JRadioButton>();
	Set<JRadioButton> sizeSetRadioButton = new HashSet<JRadioButton>();
	
	JPanel toppingsPanel = new JPanel(new GridLayout(6, 1));
	JPanel pizzaBasePanel = new JPanel(new GridLayout(6, 1));
	JPanel pizzaSizePanel = new JPanel(new GridLayout(6, 1));
	
	
	public PizzaView(String[] listOfPizzas){
		
		
		frame = new JFrame("Select Pizza Items");
		topJPanel = new JPanel();
		dialog = new JDialog(frame);
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		pizzaComboBox = new JComboBox<>(listOfPizzas);
        pizzaComboBox.setEditable(false);
        pizzaComboBoxPanel.add(pizzaComboBox);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        
        topJPanel.add(pizzaComboBoxPanel,BorderLayout.PAGE_START);
        topJPanel.add(buttonPanel,BorderLayout.PAGE_END);
        topJPanel.add(buttonPanel,BorderLayout.PAGE_END);
        
        frame.add(topJPanel);
        //frame.add(buttonPanel,BorderLayout.PAGE_END);
        //frame.add(buttonPanel,BorderLayout.PAGE_END);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
        
	}
	
	public JPanel addPizzaPanel(){
		
		toppingsSetCheckBox.add(tomatoCheckBox);
		toppingsSetCheckBox.add(cheeseCheckBox);
		toppingsSetCheckBox.add(onionCheckBox);
		toppingsSetCheckBox.add(chickenCheckBox);
		toppingsSetCheckBox.add(pepperoniCheckBox);
		toppingsSetCheckBox.add(mushroomCheckBox);
		
		if(!getPizzaDropDownValue().equals("Build Your Own Pizza")){
			boolean isPresent = true;
		    for(JCheckBox toppCheckBox:toppingsSetCheckBox){
		    	for(String toppingSel:getToppings()){
		    		if(toppCheckBox.getText().equals(toppingSel)){
		    			toppCheckBox.setSelected(true);
		    			toppingsPanel.add(toppCheckBox,BorderLayout.CENTER);
		    			isPresent = true;
		    			break;
		    		}else{
		    			isPresent = false;
		    		}
		    	}
			  	if(!isPresent){
			       	toppCheckBox.setSelected(false);
			       	toppingsPanel.add(toppCheckBox,BorderLayout.CENTER);
			       	toppingsNotSelected.add(toppCheckBox);
			    }
		    }
		}else{
			 for(JCheckBox toppCheckBox:toppingsSetCheckBox){
				 toppCheckBox.setSelected(false);
				 toppingsPanel.add(toppCheckBox,BorderLayout.CENTER);
			     toppingsNotSelected.add(toppCheckBox);
			 }
		}
	    
	    // Crust added
	    
	    crustSetRadioButton.add(panCheckBox);
	    crustSetRadioButton.add(thinCheckBox);
	    crustSetRadioButton.add(handTossedCheckBox);
	    
	    baseRadioButtonGroup.add(panCheckBox);
	    baseRadioButtonGroup.add(thinCheckBox);
	    baseRadioButtonGroup.add(handTossedCheckBox);
	    
	    
	    
	    for(JRadioButton crustCheckBox: crustSetRadioButton){
	      	if(crustCheckBox.getText().equals(baseSelected)){
	       		crustCheckBox.setSelected(true);
	       		pizzaBasePanel.add(crustCheckBox,BorderLayout.CENTER);
	      	}else{
	      		crustCheckBox.setSelected(false);
	      		pizzaBasePanel.add(crustCheckBox,BorderLayout.CENTER);
	      		baseNotSelected.add(crustCheckBox);
	       	}
	    }
	    
	    // size
	    
	    sizeRadioButtonGroup.add(size8InchCheckBox);
	    sizeRadioButtonGroup.add(size12InchCheckBox);
	    sizeRadioButtonGroup.add(size14InchCheckBox);
	    size8InchCheckBox.setSelected(true);
	    
	    sizeSetRadioButton.add(size8InchCheckBox);
	    sizeSetRadioButton.add(size12InchCheckBox);
	    sizeSetRadioButton.add(size14InchCheckBox);
	    
	       
	    pizzaSizePanel.add(size8InchCheckBox,BorderLayout.CENTER);
	    pizzaSizePanel.add(size12InchCheckBox,BorderLayout.CENTER);
	    pizzaSizePanel.add(size14InchCheckBox,BorderLayout.CENTER);
	    
	    // add all panels to main pizza panel
	    
	    pizzaItemPanel = new JPanel();
		
	    pizzaItemPanel.add(toppingsPanel,BorderLayout.EAST);
	    pizzaItemPanel.add(pizzaBasePanel,BorderLayout.CENTER);
	    pizzaItemPanel.add(pizzaSizePanel,BorderLayout.WEST);
        
        return pizzaItemPanel;
		
	}
	
	
	
	public String getPizzaDropDownValue(){
		return pizzaComboBox.getSelectedItem().toString();
	}
	
	public void addSelectComboBoxPizzaListner(ActionListener pizza){
		pizzaComboBox.addActionListener(pizza);
	}
	
	public void addSubmitButtonListner(ActionListener submit){
		submitButton.addActionListener(submit);
	}
	
	public void addCancelButtonListner(ActionListener submit){
		cancelButton.addActionListener(submit);
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
	
	public JPanel getPanel(){
		return topJPanel;
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
