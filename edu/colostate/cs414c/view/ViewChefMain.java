package edu.colostate.cs.cs414c.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewChefMain extends JPanel {
	static final JPanel cards = new JPanel(new CardLayout());
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	ViewChefOrderList objvcol;
	ViewChef objvc;   
    
    public ViewChefMain() {
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     	
    	this.objvcol = new ViewChefOrderList();
    	p1 = objvcol.getMainJPanel();
    	cards.add(p1, "Panel 1");
    	this.objvc = new ViewChef();
    	p2 = objvc.getMainJPanel();    	
    	cards.add(p2, "Panel 2");   	
    	System.out.println("Test");    
    	f.add(cards, BorderLayout.CENTER);
    	f.setSize(550, 450);
        //f.add(control, BorderLayout.SOUTH);
        f.pack();
       // f.setLocationRelativeTo(null);
        f.setVisible(true);
    	
        
    }  
    
    public ViewChefOrderList getViewChefOrderList() {
    	return this.objvcol;
    }
    
    public ViewChef getViewChef() {
    	return this.objvc;
    }
    
    
    public JPanel getCards() {
    	return cards;
    }
}
