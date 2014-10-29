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


public class ViewCashPayment {
	JLabel labelcashrendered = new JLabel("Cash Rendered");
	JLabel labelcashtotal = new JLabel("Cash Total");
	JLabel labeldisplaycashtotal = new JLabel("null");
	JLabel labelcashbalance = new JLabel("Cash Balance");
	JLabel labeldisplaycashbalance = new JLabel("null");
	JTextField txtcashrendered = new JTextField("", 20);
	JButton buttoncalculatebalance = new JButton("Calculate Balance");
	JButton buttoncashpay = new JButton("Pay");
	JButton buttoncashback = new JButton("Back");
	
	float paymentamount;
	float usergivenamount;
	static final JPanel jpanel = new JPanel(new GridLayout(0,1));
	static final JPanel jpanel1 = new JPanel(new GridLayout(3,2));
	static final JPanel jpanel2 = new JPanel();

    public ViewCashPayment() {   	 
    	 jpanel.setPreferredSize(new Dimension(320, 240));
    	 jpanel1.add(labelcashtotal, BorderLayout.WEST);
      	 jpanel1.add(labeldisplaycashtotal, BorderLayout.CENTER);
    	 jpanel1.add(labelcashrendered, BorderLayout.WEST);
     	 jpanel1.add(txtcashrendered, BorderLayout.CENTER);
     	 jpanel1.add(labelcashbalance, BorderLayout.WEST);
     	 jpanel1.add(labeldisplaycashbalance, BorderLayout.CENTER);
     	 jpanel.add(jpanel1);
     	
     	 jpanel2.add(buttoncalculatebalance);
    	 jpanel2.add(buttoncashpay);
         jpanel2.add(buttoncashback);
         jpanel.add(jpanel2, BorderLayout.SOUTH);       

     }
     
     public ViewCashPayment(int n) {}     
     
     public void activateListener(ActionListener al){
    	 buttoncalculatebalance.addActionListener(al);
    	 buttoncashpay.addActionListener(al);
    	 buttoncashback.addActionListener(al);
    	 
     }
     
     public JButton getCalculateButton() {
    	 return buttoncalculatebalance;
     }
     
     public JButton getCashPayButton() {
    	 return buttoncashpay;
     }
     
     public JButton getCashbackButton() {
    	 return buttoncashback;
     }
     
     public JLabel getlabeldisplaycashtotal() {
    	 return this.labeldisplaycashtotal;
     }
     
     public JLabel getLabeldisplaycashbalance() {
    	 return this.labeldisplaycashbalance;
     }
     
     public JTextField getTextCashRendered() {
    	 return this.txtcashrendered;
     }
     
     public JPanel getMainJPanel() {
    	 return jpanel;
     }

}
