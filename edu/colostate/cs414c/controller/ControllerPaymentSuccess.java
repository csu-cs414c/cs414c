package Card;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class ControllerPaymentSuccess {
	//ViewMain objviewmain = new ViewMain();
	
	ViewPaymentSuccess objviewSuccesspayment;
	//ViewMain objmain;
	//ViewCashPayment objviewcashpayment;
	//ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerPaymentSuccess() {
		//new ControllerCashPayment();
		System.out.println("actionPaymentSuccess");
		this.objviewSuccesspayment = new ViewPaymentSuccess();
		//this.objviewcashpayment = new ViewCashPayment();
		//this.objviewcardpayment = new ViewCardPayment();
		//this.objcontcardpayment = new ControllerCardPayment();
		//this.objcontcashpayment = new ControllerCashPayment();
		//this.objmain = new ViewMain();
		
		//objviewSuccesspayment.activateListener(new PaymentSuccessListener());
		
		
	}
	
	
}
