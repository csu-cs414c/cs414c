/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import edu.colostate.cs414c.model.Order;
import edu.colostate.cs414c.view.CashierView;

public class CashierController {

	private CashierView cashierView;
	private String user;

	public CashierController(String user){
		this.user=user;
		this.cashierView = new CashierView(user);
		this.cashierView.ButtonListner(new CashierHomeListner());
	}

	class CashierHomeListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==cashierView.getTakeOrderButton()){
				//new Order(user,"cashier");
                            MenuController menuController = new MenuController();
				cashierView.setVisible(false);
			}
			else if(e.getSource()==cashierView.getLogOutButton()){
				new LoginController();
				cashierView.setVisible(false);
			}
			//else if(e.getSource()==cashierView.getViewOrderbutton()){
			//	new ViewOrderController(user);
			//	cashierView.setVisible(false);
			}
			//else if(e.getSource()==cashierView.getViewSplButton()){
			//	new ViewSpecialController(user);
			//	cashierView.setVisible(false);
			}
        
        public static void main(String args[])  {
            new CashierController("cashier");
        }
		}
	//}

//}


