package edu.colostate.cs414c.controller;


import edu.colostate.cs414c.view.MenuView;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


/**
 *
 * @author pavithra
 */
public class MenuController {
    public MenuView mview;
    private Menu mmodel;
    
  //JPanel cl = new JPanel();


	public MenuController(){
		this.mview = new MenuView();
		this.mmodel = new Menu();
                System.out.println("test");
               
                //c1 = mview.getCards();
		this.mview.buttonListener(new MenuController.MenuListener());
	}
        
       class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {                    
                  if(e.getSource() == mview.getPlaceOrder())    {

                      Container c1 = new JPanel((LayoutManager) mview.getCards()); 
                 
                    //c1.(mview.getCards(), "Panel 2");
                    CardLayout c2 = (CardLayout) c1.getLayout();
                     System.out.println("inside card");
                        
                      

               c2.show(c1,"Panel 2");
                c2.next(c1);
                }
                  else if(e.getSource() == mview.getExit()) {
                      System.exit(0);
                  }
                             
             }
        
	
	
}
 
 public static void main(String args[])
   {
       EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	
           new MenuController();
            }
        });
   }
  
}
