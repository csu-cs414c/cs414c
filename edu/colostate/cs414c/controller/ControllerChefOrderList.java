package edu.colostate.cs.cs414c.controller;

import edu.colostate.cs.cs414c.view.ViewChef;
import edu.colostate.cs.cs414c.view.ViewChefMain;
import edu.colostate.cs.cs414c.view.ViewChefOrderList;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControllerChefOrderList {
	ViewChefOrderList objvcol;
	ViewChefMain objviewmain;
	ViewChef objviewchef;
	
	public ControllerChefOrderList(ViewChefMain objviewmain) {
		this.objviewmain = objviewmain;
		objvcol = objviewmain.getViewChefOrderList();
		objviewchef = objviewmain.getViewChef();
		objvcol.activateListener(new ChefOrderListListener());
	}
	
	class ChefOrderListListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		//ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objvcol.getChefViewOrderButton())) {
				System.out.println("inside");
				//objviewchef.setObjects();
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 2");			
				
			}
		}		
	}
}
