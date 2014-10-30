package edu.colostate.cs.cs414c.view;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DealOfDayView {
	

	JFrame frame;
	JPanel topJPanel;
	JPanel dealOfDayCheckBoxView = new JPanel();
	
	JButton submitButton =new JButton("Submit");
	JButton cancelButton = new JButton("Cancel");
	
	Map<String, String> deal = new HashMap<String, String>();
	
	JLabel dealLabel =  new JLabel();
	JCheckBox dealCheckBox = new JCheckBox("Deal");
	
	JPanel labelErroPanel = new JPanel();
	float price = 0.0f;
	
	
	public DealOfDayView(Map<String, String> deal){
		this.deal = deal;
		frame = new JFrame("Select Deal Of Day");
		topJPanel = new JPanel();
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		System.out.println("Into");
		 JPanel buttonPanel = new JPanel();
	     buttonPanel.add(submitButton);
	     buttonPanel.add(cancelButton);
		

	    Set<String> keyValues = deal.keySet();
		Iterator<String> itr = keyValues.iterator();
		System.out.println("Size is "+ keyValues.size());
		while(itr.hasNext()){
			System.out.println("Iterating");
			String key = itr.next();
			if(key.toString().equals("price")){
				price = Float.parseFloat(deal.get(key));
				setDealPrice(price);
			}
			JLabel newLabel = new JLabel(key +" : "+deal.get(key));
			dealLabel.add(newLabel);
		}
		
	     
	    dealOfDayCheckBoxView.add(dealCheckBox);
		
		
		topJPanel.add(dealOfDayCheckBoxView);
		topJPanel.add(dealLabel);
		topJPanel.add(buttonPanel);
		
		frame.add(topJPanel);
        
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
		
	}
	
	public JCheckBox getCheckBox(){
		return dealCheckBox;
	}
	
	public void setDealPrice(float price){
		this.price = price;
		
	}
	
	public float getDealPrice(){
		return this.price;
	}
	
	public void addSubmitButtonListner(ActionListener submit){
		submitButton.addActionListener(submit);
	}
	
	public void addCancelButtonListner(ActionListener submit){
		cancelButton.addActionListener(submit);
	}
	
	public void displayErroMessage(String errMessage){
		labelErroPanel = new JPanel();
		System.out.println("message "+errMessage);
		JLabel newJLabel = new JLabel(errMessage);
		labelErroPanel.add(newJLabel);
		topJPanel.add(labelErroPanel);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	

}
