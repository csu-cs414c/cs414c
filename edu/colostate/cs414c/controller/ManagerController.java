/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.controller;

/**
 *
 * @author pavithra
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import edu.colostate.cs414c.view.ManagerView;

public class ManagerController 
{
	private ManagerView managerView;
	private String user;
	
	public ManagerController(String user)
	{
		this.user=user;
		this.managerView = new ManagerView(user);
		this.managerView.ButtonListener(new ManagerActionListener());
	}

	class ManagerActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton tempButton = (JButton)e.getSource();
		    			
			if(tempButton.equals(managerView.getDefineMenuButton()))
	        {
				//new DefineMenuController(user);
				managerView.setVisible(false);
	        }
	        else if(tempButton.equals(managerView.getModifyMenuButton())) 
	        {
                             new MenuController();                 
                             managerView.setVisible(false);
                        
                        
	        }
	        else if(tempButton.equals(managerView.getSetSpecialButton())) 
	        {
	        	managerView.setVisible(false);
	        	//new SetSpecialController(user);
	        }
	        else if(tempButton.equals(managerView.getViewOrderButton())) 
	        {       
	        	managerView.setVisible(false);
	        	//new ViewOrderController(user);
	        }
	      /*  else if(tempButton.equals(managerView.getInventoryButton())) 
	        {
	        	managerView.setVisible(false);
	        	new InventoryController(user);
	        } */
	        else if(tempButton.equals(managerView.getLogoutButton())) 
	        {
	        	managerView.setVisible(false);
	        	new LoginController();
	        }
		}
	}
        
        public static void main(String args[])  {
            new ManagerController("manager");
        }
} 


