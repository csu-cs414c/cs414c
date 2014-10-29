package Card;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class ControllerPayment {
	//ViewMain objviewmain = new ViewMain();
	
	ViewPayment objviewpayment;
	//ViewMain objmain;
	//ViewCashPayment objviewcashpayment;
	//ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerPayment(ViewPayment objviewpayment) {
		this.objviewpayment = objviewpayment;
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
	
	class PaymentListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objviewpayment.getCashPaymentButton())) {
				System.out.println("inside");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 2");
				
				
			} else if(button.equals(objviewpayment.getCardPaymentButton())) {
				System.out.println("inside");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 3");
			
			}
			
		}
		
	}
}
