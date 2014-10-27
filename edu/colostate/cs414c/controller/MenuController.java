package edu.colostate.cs414c.controller;


import edu.colostate.cs414c.view.MenuView;
import edu.colostate.cs414c.view.SaleLineItem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author pavithra
 */
public class MenuController {
    public MenuView mview;
    private Menu mmodel;
    public SaleLineItem saleview;
    public TakeOrderController editmenu;
    
  //JPanel cl = new JPanel();
    private final JFrame frame ;
    private final JPanel panel;


	public MenuController() {
		this.mview = new MenuView();
		this.mmodel = new Menu();
                this.frame = mview.getFrame();
                this.saleview= new SaleLineItem();
                System.out.println("test");
               
                this.panel = saleview.getPanel();
                this.mview.buttonListener(new MenuController.MenuListener());
	}
        
       class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {                    
                  if(e.getSource() == mview.getPlaceOrder())    {
                      frame.add(panel, BorderLayout.CENTER);
                     // panel.setOpaque(true);
                    frame.setContentPane(panel);
                    frame.isResizable();
                    frame.revalidate();
                    frame.repaint();
                   // frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    //editmenu = new TakeOrderController();
                   
                   
                    
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
