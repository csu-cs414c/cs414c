package edu.colostate.cs.cs414c.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.colostate.cs.cs414c.model.DealOfTheDay;
import edu.colostate.cs.cs414c.model.Drink;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.view.DealOfDayView;
import edu.colostate.cs.cs414c.view.ViewMain;

public class DealOfDayController {

	
	private Item item;
	private JFrame frame;
	
	ViewMain viewMain;
	JTable table;
	DealOfDayView dealOfDayView;
	DealOfTheDay dealOfDayModel;
	
	public DealOfDayController(){
		this.viewMain = viewMain;
		this.table = table;
		dealOfDayModel = new DealOfTheDay("Deal Of Day");
		
		dealOfDayView = new DealOfDayView(dealOfDayModel.dealOfTheDay());
		
		dealOfDayView.addSubmitButtonListner(new SelectButtonListner());
		dealOfDayView.addCancelButtonListner(new CancelButtonListner());
		
	}
	
	class SelectButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame = dealOfDayView.getFrame();
			if(dealOfDayView.getCheckBox().isSelected()){
							
				frame.setVisible(false);
				frame.dispose();
			}else{
				System.out.println("Into");
				dealOfDayView.displayErroMessage("Select the deal of day or cancel to exit");
				frame.setVisible(true);
			}
			
			System.out.println("Name : ----"+ dealOfDayModel.getDealOfDayName());
			System.out.println("Item Price --- : "+ dealOfDayView.getDealPrice());
			
			CardLayout cll = (CardLayout) viewMain.getCards().getLayout();
			cll.show(viewMain.getCards(),"Panel 3");
			System.out.println("Name : ----"+ dealOfDayModel.getDealOfDayName());
			System.out.println("Item Price --- : "+ dealOfDayView.getDealPrice());
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object[]{dealOfDayModel.getDealOfDayName(), dealOfDayView.getDealPrice(), false});
		}
		
	}
	
	class CancelButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame = dealOfDayView.getFrame();
			frame.setVisible(false);
			frame.dispose();
			
			
		}
	}
	
	public static void main(String[] args){
		new DealOfDayController();
	}
}
