package Card;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ViewPayment {
	private JButton buttoncashpayment = new JButton("Cash Payment");
	private JButton buttoncardpayment = new JButton("Card Payment");
	static final JPanel jpanel = new JPanel();
	

     public ViewPayment() {   	 
    	 jpanel.setPreferredSize(new Dimension(320, 240));
    	 jpanel.add(buttoncashpayment);
         jpanel.add(buttoncardpayment);
        

    }
     
     public ViewPayment(int n) {
    	 
     }
     
     public void activateListener(ActionListener al){
    	 buttoncashpayment.addActionListener(al);
    	 buttoncardpayment.addActionListener(al);
    	 
     }
     
     public JButton getCashPaymentButton() {
    	 return buttoncashpayment;
     }
     
     public JButton getCardPaymentButton() {
    	 return buttoncardpayment;
     }
     
     public JPanel getMainJPanel() {
    	 return jpanel;
     }
     
}
     
    
     
     



