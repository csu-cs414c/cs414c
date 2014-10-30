package edu.colostate.cs.cs414c.controller;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.colostate.cs.cs414c.model.ModelPayment;
import edu.colostate.cs.cs414c.view.ViewCashPayment;
import edu.colostate.cs.cs414c.view.ViewMain;

public class ControllerCashPayment {
	//ViewMain objviewmain = new ViewMain();
	
	//ViewPayment objviewpayment;
	//ViewMain objmain;
	ViewMain objviewmain;
	ViewCashPayment objviewcashpayment;
	ModelPayment objmodelpayment;
	float paymentamount;

	//ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerCashPayment(ViewMain objviewmain, ModelPayment objmodelpayment) {
		this.objmodelpayment = objmodelpayment;
		this.objviewmain = objviewmain;
		this.objviewcashpayment = objviewmain.getviewcashpayment();
		//new ControllerCashPayment();
		System.out.println("action");
		//this.objviewpayment = new ViewPayment(10);
		//this.objviewcashpayment = new ViewCashPayment();
		//this.objviewcardpayment = new ViewCardPayment();
		//this.objcontcardpayment = new ControllerCardPayment();
		//this.objcontcashpayment = new ControllerCashPayment();
		//this.objmain = new ViewMain();
		
		objviewcashpayment.activateListener(new CashPaymentListener());
		System.out.println("some");	
		
	}
	
	public void setControllerCashPayment(float paymentamount) {
		this.paymentamount = paymentamount;
		String str_paymentamount;
   	 	this.objmodelpayment = new ModelPayment(paymentamount);    	 
   	 	str_paymentamount = paymentamount+"";
   	 	objviewcashpayment.getlabeldisplaycashtotal().setText(str_paymentamount);		
	}
	
	class CashPaymentListener implements ActionListener {		
		//private JFrame jframe;
		//private JPanel jpanel;
		//ViewMain objviewmain = new ViewMain();
		//ModelCashPayment objmodelcashpayment = new ModelCashPayment(10);
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("Cash ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objviewcashpayment.getCalculateButton())) {
				String str_cashrendered = objviewcashpayment.getTextCashRendered().getText();
				System.out.println("Cash rendered: "+str_cashrendered);
				objmodelpayment.setCashRendered(Float.parseFloat(str_cashrendered));
				System.out.println("inside calculate balance: "+objmodelpayment.calculateChange());				
				objviewcashpayment.getLabeldisplaycashbalance().setText(objmodelpayment.calculateChange()+"");				
			} else if(button.equals(objviewcashpayment.getCashPayButton())) {
				System.out.println("inside cash ");
				
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 7");
				
				
			} else if(button.equals(objviewcashpayment.getCashbackButton())) {
				System.out.println("inside cash ");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 4");
			
			}
			
		}
		
	}
}
