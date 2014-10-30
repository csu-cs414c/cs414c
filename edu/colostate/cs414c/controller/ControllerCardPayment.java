package edu.colostate.cs.cs414c.controller;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.colostate.cs.cs414c.model.ModelCardPayment;
import edu.colostate.cs.cs414c.model.ModelPayment;
import edu.colostate.cs.cs414c.view.ViewCardPayment;
import edu.colostate.cs.cs414c.view.ViewMain;
import edu.colostate.cs.cs414c.view.ViewPayment;

public class ControllerCardPayment {
	//ViewMain objviewmain = new ViewMain();
	
	ViewPayment objviewpayment;
	ViewMain objviewmain;
	ViewCardPayment objviewcardpayment;
	float paymentamount;
	ModelCardPayment objmodelcardpayment;
	//ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerCardPayment(ViewMain objviewmain, ModelPayment objmodelpayment) {
		//new ControllerCashPayment();
		this.objviewmain = objviewmain;
		System.out.println("action");
		this.objviewcardpayment = objviewmain.getviewcardpayment();
		//this.objviewcardpayment = new ViewCardPayment();
		//this.objcontcardpayment = new ControllerCardPayment();
		//this.objcontcashpayment = new ControllerCashPayment();
		//this.objmain = new ViewMain();
		
		objviewcardpayment.activateListener(new CardPaymentListener());
		System.out.println("some card");
		
		
	}
	
	public void setControllerCardPayment(float paymentamount) {
		this.paymentamount = paymentamount;
		String str_paymentamount;
   	 	this.objmodelcardpayment = new ModelCardPayment(paymentamount);    	 
   	 	str_paymentamount = paymentamount+"";
   	 	objviewcardpayment.getLabeldisCashTotal().setText(str_paymentamount);		
	}
	
	class CardPaymentListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		//ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("Card ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objviewcardpayment.getCardPayButton())) {
				System.out.println("inside card ");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 7");
				
				
			} else if(button.equals(objviewcardpayment.getCardbackButton())) {
				System.out.println("inside card ");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 4");
			
			}
			
		}
		
	}
}
