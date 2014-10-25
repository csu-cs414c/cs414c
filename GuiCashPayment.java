import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GuiCashPayment extends JPanel implements ActionListener {
	JTextField txtcashrendered, txttotalbill, txtcardno, txtcardname, txtcardexpiry, txtcardcvv;
	JLabel labelcashrendered, labeltotalbill, labelcardno, labelcardname, labelpaymentdone, labelcardexpiry, labelcardcvv ;
	JButton buttoncashback, buttoncashpay;
	
	public void create() {
     	add(buttoncashback);
     	buttoncashback.addActionListener(this);
     	add(buttoncashpay);
     	buttoncashpay.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.equals(buttoncashback)) {
			CardLayout cl = (CardLayout) GuiMain.contentPane.getLayout();
			cl.show(GuiMain.contentPane, "Panel 1");
			
			
		} else if(button.equals(buttoncashpay)) {
			CardLayout cl = (CardLayout) GuiMain.contentPane.getLayout();
			cl.show(GuiMain.contentPane, "Panel 1");		
		
		}
	}

	
}
