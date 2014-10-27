/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.controller;

import edu.colostate.cs414c.view.SaleLineItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pavithra
 */
public class TakeOrderController {
 public SaleLineItem salelineitem;
//private Menu menu;
    public TakeOrderController()
	{      
                
		//this.user=user;
		//this.menu = Menu.getInstance();
		this.salelineitem = new SaleLineItem();
		this.salelineitem.buttonListener(new TakeOrderController.TakeOrderActionListener());

	}

  
   
    class TakeOrderActionListener implements ActionListener {
           @Override
           public void actionPerformed(ActionEvent e)  {
               
             
            if(e.getSource() == salelineitem.getaddItem())
              //  SelectMenuController.getInstance();
                
        
        if(e.getSource() == salelineitem.getcancel())   {
            new MenuController();
            salelineitem.setVisible(true);
        }
        
        if(e.getSource() == salelineitem.getremoveItem())   {
           // SelectMenuController.getInstance();
        }
        
        if(e.getSource() == salelineitem.getsubmit())   {
            //new ViewMain();
        }
     
        
    }

}

}

