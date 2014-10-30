package edu.colostate.cs.cs414c.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AddOnView {

	private JFrame frame;
	private JPanel addOnPanel = new JPanel();
	private JRadioButton addOnRadioButton;
	
	private JPanel topJPanel;
	
	private JButton submitButton =new JButton("Submit");
	private JButton cancelButton = new JButton("Cancel");
	
	private ButtonGroup addOnsRadioButtonGroup = new ButtonGroup();
	private Set<JRadioButton> addOnsSetRadioButton = new HashSet<JRadioButton>();
	
	JPanel addOnItemPanel = new JPanel(new GridLayout(6, 1));
	
	public AddOnView(String[] addOns){
		
		frame = new JFrame("Select AddOn Items");
		topJPanel = new JPanel();
		frame.setSize(600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
				
		JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        
        for(int i=0;i<addOns.length;i++){
			addOnRadioButton = new JRadioButton(addOns[i]);
			addOnsRadioButtonGroup.add(addOnRadioButton);
			addOnsSetRadioButton.add(addOnRadioButton);
			addOnPanel.add(addOnRadioButton);
		}
		
		addOnItemPanel.add(addOnPanel,BorderLayout.CENTER);
		topJPanel.add(addOnItemPanel);
		topJPanel.add(buttonPanel,BorderLayout.PAGE_START);
        frame.add(topJPanel,BorderLayout.PAGE_START);
        
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
		
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
	
	public String getAddOnSelected(){
		Iterator<JRadioButton> iterator = addOnsSetRadioButton.iterator();
		while(iterator.hasNext()){
			JRadioButton userSelected = iterator.next();
			if(userSelected.isSelected()){
				return userSelected.getText() ;
			}
		}
		return null;
	}
	
	
}
