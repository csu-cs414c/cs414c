package Card;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewPaymentSuccess {
	private JLabel labelcashpayment = new JLabel("Thank you!! Your Payment is successfull");
	//private JButton buttoncardpayment = new JButton("Card Payment");
	static final JPanel jpanel = new JPanel();
	

     public ViewPaymentSuccess() {   	 
    	 jpanel.setPreferredSize(new Dimension(320, 240));
    	 jpanel.add(labelcashpayment);
        

    }
     
     public ViewPaymentSuccess(int n) {
    	 
     }
     
     public JPanel getMainJPanel() {
    	 return jpanel;
     }
     
}
     
    
     
     



