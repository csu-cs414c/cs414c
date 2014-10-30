package edu.colostate.cs.cs414c.controller;

import java.awt.EventQueue;

import edu.colostate.cs.cs414c.model.ModelPayment;
//import edu.colostate.cs.cs414c.view.StoreView;
import edu.colostate.cs.cs414c.view.ViewMain;

public class ControllerMain {	
	
	public ControllerMain() {
		ViewMain objviewmain = new ViewMain();
		ModelPayment objmodelpayment = new ModelPayment(0);
		new ControllerAddSaleLineItem(objviewmain, objmodelpayment);
		ControllerPayment objpayment = new ControllerPayment(objviewmain, objmodelpayment);
		ControllerCashPayment objccp = new ControllerCashPayment(objviewmain, objmodelpayment);
		new ControllerCardPayment(objviewmain, objmodelpayment);
		new ControllerPaymentSuccess(objviewmain);		
	}
	
}
