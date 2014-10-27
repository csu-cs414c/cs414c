package edu.colostate.cs414c.view;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pavithra
 */
public class MenuView extends JPanel {
   JPanel cards = new JPanel(new CardLayout()); 
           JPanel panel2 = new JPanel();
   JButton placeorder, exit;
   JLabel title = new JLabel("Pizza House");
   JLabel menu, pizza, drinks, addons;
   
   String name;
   
   
JPanel panel1 = new JPanel();
 JFrame f = new JFrame();
   
    private MenuView(String name) {
           this.name = name;
        this.setPreferredSize(new Dimension(320, 240));   
     }
   
   public MenuView()    {
       
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,700);
        f.setTitle("VIEW MENU");
	//this.add(panel);
       MenuView p1 = new MenuView("Panel 1");
        MenuView p2 = new MenuView("Panel 2");
        p1.setLayout(new GridLayout(0,1));
        p2.setLayout(new GridLayout(0,1));
        
        

       //Make JFrame visible
    
        //panel.setLayout(new GridLayout(0,1));
	//setBounds();
	
       
       panel1.setLayout(new GridLayout(8,2));
        panel1.add(title,BorderLayout.CENTER);
       String newline = System.getProperty("line.separator");
       
        pizza = new JLabel("Pizza : cheese pizza," + newline
                + " hawaiian fiesta,"  + newline
                + " american feast" + newline);
        panel1.add(pizza, BorderLayout.LINE_START);
        drinks = new JLabel("Drinks : coke, pepsi, sprite");
        panel1.add(drinks,BorderLayout.LINE_END);
        addons = new JLabel("Addons : pasta, fries, breadsticks");
        panel1.add(addons,BorderLayout.WEST);
         placeorder = new JButton("Place Order");
     	panel1.add(placeorder, BorderLayout.SOUTH);
     	exit = new JButton("Exit");
         panel1.add(exit, BorderLayout.SOUTH);
       
       
       // p1.add(panel1);

        
       // p2.add(panel2);
        
       
        //add cards
        
        //cards.add(p1, p1.toString());
       // cards.add(p2, p2.toString());
        
        //getContentPane().add(cards); 
        setVisible(true); 
           
        f.add(panel1, BorderLayout.CENTER);
        //f.add(control, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        
        
   }
   
  
   
  
  public void buttonListener(ActionListener l)
  {
     
      placeorder.addActionListener(l);
        exit.addActionListener(l);
        //item.addActionListener(l);
  }
        
   
   public JButton getPlaceOrder() {
		return placeorder;
	}
   public JButton getExit() {
       return exit;
   }

   public JPanel getCards() {
        return cards;
    }
   
   @Override
    public String toString() {
        return name;
    }

    private void calculate_cost() {
        
    }
    
    public JPanel getPanel() {
		return panel2;
	}

    public JFrame getFrame()    {
        return f;
    }
public static void main(String args[]){
    new MenuView();
}


  
}
