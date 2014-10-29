package Card;

import java.awt.EventQueue;

public class ControllerMain {	
	
	public ControllerMain() {		
		ViewMain objviewmain = new ViewMain();
		new ControllerPayment(objviewmain.getviewpayment());
		ControllerCashPayment objccp = new ControllerCashPayment(objviewmain, objviewmain.getviewcashpayment());
		objccp.setControllerCashPayment(100);
		new ControllerCardPayment(objviewmain.getviewcardpayment());
		new ControllerPaymentSuccess();
		
	}
	
	public static void main(String args[])
    {
    	 EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {             	
                new ControllerMain();
             }
         });                
         
    }
}
