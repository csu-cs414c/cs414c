package Card;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewMain extends JPanel {
	static final JPanel cards = new JPanel(new CardLayout());
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();    
    ViewPayment objvp;
    ViewCashPayment objcp;
    ViewCardPayment objcap;
    ViewPaymentSuccess objvps;
    
    public ViewMain() {
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     	
    	this.objvp = new ViewPayment();
    	p1 = objvp.getMainJPanel();    	
    	cards.add(p1, "Panel 1");    	
    	this.objcp = new ViewCashPayment();
    	p2 = objcp.getMainJPanel();
    	cards.add(p2, "Panel 2");    	
    	this.objcap = new ViewCardPayment();
    	p3 = objcap.getMainJPanel();
    	cards.add(p3, "Panel 3");    	
    	this.objvps = new ViewPaymentSuccess();
    	p4 = objvps.getMainJPanel();
    	cards.add(p4, "Panel 4");
    	System.out.println("Test");
    	f.add(cards, BorderLayout.CENTER);
    	f.setSize(550, 450);
        //f.add(control, BorderLayout.SOUTH);
        f.pack();
       // f.setLocationRelativeTo(null);
        f.setVisible(true);
    	
        
    }
    
    
    public ViewPayment getviewpayment() {
    	return this.objvp;
    }
    
    public ViewCashPayment getviewcashpayment() {
    	return this.objcp;
    }
    
    public ViewCardPayment getviewcardpayment() {
    	return this.objcap;
    }
    
    public ViewPaymentSuccess getviewpaymentsuccess() {
    	return this.objvps;
    }
    
    public JPanel getCards() {
    	return cards;
    }

    
    

}
