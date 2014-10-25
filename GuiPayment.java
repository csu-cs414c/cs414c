
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiPayment extends JPanel implements ActionListener  {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    String name;
    JButton buttoncashpayment, buttoncreditpayment;
	JTextField txtcashrendered, txttotalbill, txtcardno, txtcardname, txtcardexpiry, txtcardcvv;
	JLabel labelcashrendered, labeltotalbill, labelcardno, labelcardname, labelpaymentdone, labelcardexpiry, labelcardcvv ;
	
	public GuiPayment() {
		create();
	}

    
    

    public void create() {
    	
        buttoncashpayment = new JButton("Cash Payment");
     	add(buttoncashpayment);
     	buttoncreditpayment = new JButton("Credit Payment");
     	add(buttoncreditpayment);
     	buttoncashpayment.addActionListener(this);   	
     	buttoncreditpayment.addActionListener(this);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		GuiMain obj = new GuiMain();
		JButton button = (JButton)e.getSource();
		if(button.equals(buttoncashpayment)) {
			CardLayout cl = (CardLayout) obj.getCard();
			cl.show(GuiMain.contentPane, "Panel 2");
			
			
		} else if(button.equals(buttoncreditpayment)) {
			CardLayout cl = (CardLayout) GuiMain.contentPane.getLayout();
			cl.show(GuiMain.contentPane, "Panel 2");		
		
		}
	}
}