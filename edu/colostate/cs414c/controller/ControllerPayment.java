package edu.colostate.cs.cs414c.controller;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//import javax.swing.JFrame;
//import javax.swing.JPanel;

import edu.colostate.cs.cs414c.model.ModelPayment;
import edu.colostate.cs.cs414c.view.ViewCardPayment;
import edu.colostate.cs.cs414c.view.ViewCashPayment;
import edu.colostate.cs.cs414c.view.ViewMain;
import edu.colostate.cs.cs414c.view.ViewPayment;

public class ControllerPayment {
	//ViewMain objviewmain = new ViewMain();
	float paymentamount;
	ViewMain objviewmain;
	ViewPayment objviewpayment;
	ModelPayment objmodelpayment;
	//ViewMain objmain;
	ViewCashPayment objviewcashpayment;
	ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerPayment(ViewMain objviewmain, ModelPayment objmodelpayment) {
		this.objviewmain = objviewmain;
		this.objmodelpayment = objmodelpayment;
		this.objviewpayment = objviewmain.getviewpayment();
		objviewcashpayment = objviewmain.getviewcashpayment();
		objviewcardpayment = objviewmain.getviewcardpayment();
		
		//new ControllerCashPayment();
		System.out.println("action1");
		//this.objviewpayment = new ViewPayment(10);
		//this.objviewcashpayment = new ViewCashPayment();
		//this.objviewcardpayment = new ViewCardPayment();
		//this.objcontcardpayment = new ControllerCardPayment();
		//this.objcontcashpayment = new ControllerCashPayment();
		//this.objmain = new ViewMain();
		
		objviewpayment.activateListener(new PaymentListener());
		
		
	}
	
	public void setControllerPayment(float paymentamount) {
		this.paymentamount = paymentamount;
   	 	this.objmodelpayment = new ModelPayment(paymentamount);    	 
   	 	
	}
	
	
	
	
	class PaymentListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		//ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objviewpayment.getCashPaymentButton())) {
				System.out.println("inside payment cash total "+objmodelpayment.getPaymentAmount());
				objviewcashpayment.getlabeldisplaycashtotal().setText(objmodelpayment.getPaymentAmount()+"");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 5");
				
				
			} else if(button.equals(objviewpayment.getCardPaymentButton())) {
				System.out.println("inside payment card total "+objmodelpayment.getPaymentAmount());
				objviewcardpayment.getLabeldisCashTotal().setText(objmodelpayment.getPaymentAmount()+"");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 6");
			
			}
			
		}
		
	}
}
