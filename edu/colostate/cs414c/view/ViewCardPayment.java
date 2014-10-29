package Card;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewCardPayment {
	JTextField txtcardname = new JTextField("", 20);
	JTextField txtcardno = new JTextField("", 20);
	JTextField txtcardcvv = new JTextField("", 20);
	JTextField txtcardexpiry = new JTextField("", 20);
	JLabel labelcashtotal = new JLabel("Cash Total");
	JLabel labelcashtotaldisplay = new JLabel("null");
	JLabel labelcardname = new JLabel("Card Name");
	JLabel labelcardno = new JLabel("Card No.");
	JLabel labelcardcvv = new JLabel("Card CVV");
	JLabel labelcardexpiry = new JLabel("Card Expiry");
	JButton buttoncardpay = new JButton("Pay");
	private JButton buttoncardback = new JButton("Back");
	static final JPanel jpanel = new JPanel(new GridLayout(0,1));
	//JPanel jpanel = new JPanel(new GridLayout(8,2));
	static final JPanel jpanel1 = new JPanel(new GridLayout(7,2));
	static final JPanel jpanel2 = new JPanel();

     public ViewCardPayment() {   	 
    	 jpanel.setPreferredSize(new Dimension(320, 240));
    	 jpanel1.add(labelcashtotal, BorderLayout.WEST);
    	 jpanel1.add(labelcashtotaldisplay, BorderLayout.CENTER);
    	 jpanel1.add(labelcardname, BorderLayout.WEST);
    	 jpanel1.add(txtcardname, BorderLayout.CENTER);
    	 jpanel1.add(labelcardno, BorderLayout.WEST);
    	 jpanel1.add(txtcardno, BorderLayout.CENTER);
    	 jpanel1.add(labelcardcvv, BorderLayout.WEST);
    	 jpanel1.add(txtcardcvv, BorderLayout.CENTER);
    	 jpanel1.add(labelcardexpiry, BorderLayout.WEST);
    	 jpanel1.add(txtcardexpiry, BorderLayout.CENTER);
        //jpanel.setLayout(new BorderLayout());
        jpanel2.add(buttoncardpay, BorderLayout.WEST);
        jpanel2.add(buttoncardback, BorderLayout.CENTER);
        jpanel.add(jpanel1);
        jpanel.add(jpanel2, BorderLayout.SOUTH);
        

    }
     
     public ViewCardPayment(int n) {
    	 
     }
     
     public void activateListener(ActionListener al){
    	 buttoncardpay.addActionListener(al);
    	 buttoncardback.addActionListener(al);
    	 
     }
     
     public JButton getCardPayButton() {
    	 return buttoncardpay;
     }
     
     public JButton getCardbackButton() {
    	 return buttoncardback;
     }
     
     public JLabel getLabelCashTotal() {
    	 return labelcashtotal;
     }
     
     public JPanel getMainJPanel() {
    	 return jpanel;
     }



}
