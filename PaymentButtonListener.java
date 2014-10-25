

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class PaymentButtonListener extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel topPanel;
	JPanel middlepanel;
	JPanel bottompanel;
	JButton buttoncashpayment;
	JButton buttoncreditpayment;
     
    public PaymentButtonListener() {
    	frame = new JFrame();
    	frame.setLayout(new BorderLayout());

    	topPanel = new JPanel();
    	topPanel.add(new JLabel(" "));    	
    	JPanel middlepanel = new JPanel();

    	JPanel bottomPanel = new JPanel();

    	middlepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	buttoncashpayment = new JButton("Cash Payment");
    	buttoncashpayment.addActionListener(this);
    	middlepanel.add(buttoncashpayment);
    	buttoncreditpayment = new JButton("Credit Payment");
    	middlepanel.add(buttoncreditpayment);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(topPanel, BorderLayout.NORTH);
    	frame.add(middlepanel, BorderLayout.CENTER);
    	frame.add(bottomPanel, BorderLayout.SOUTH);
    	frame.setSize(400, 300);
    	//frame.setLayout(new GridLayout(1, 1));
        frame.setVisible(true);
    	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.equals(buttoncashpayment)) {
			JOptionPane.showInputDialog("You want to pay as cash");
		} else if(button.equals(buttoncreditpayment)) {
			JOptionPane.showInputDialog("You want to pay as credit");
		}
		
	}
}
