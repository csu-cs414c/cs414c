package Card;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControllerCardPayment {
	//ViewMain objviewmain = new ViewMain();
	
	ViewPayment objviewpayment;
	//ViewMain objmain;
	ViewCardPayment objviewcardpayment;
	float paymentamount;
	ModelCardPayment objmodelcardpayment;
	//ViewCardPayment objviewcardpayment;
	//ControllerCashPayment objcontcashpayment;
	//ControllerCardPayment objcontcardpayment;
	
	
	public ControllerCardPayment(ViewCardPayment objviewcardpayment) {
		//new ControllerCashPayment();
		System.out.println("action");
		this.objviewpayment = new ViewPayment();
		this.objviewcardpayment = new ViewCardPayment();
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
   	 	//objviewcardpayment.getlabeldisplaycashtotal().setText(str_paymentamount);		
	}
	
	class CardPaymentListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("Card ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objviewcardpayment.getCardPayButton())) {
				System.out.println("inside card ");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 4");
				
				
			} else if(button.equals(objviewcardpayment.getCardbackButton())) {
				System.out.println("inside card ");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 1");
			
			}
			
		}
		
	}
}
