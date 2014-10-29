package chef;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewMain extends JPanel {
	static final JPanel cards = new JPanel(new CardLayout());
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	   
    
    public ViewMain() {
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     	
    	ViewChefOrderList objvcol = new ViewChefOrderList(10);
    	p1 = objvcol.getMainJPanel();
    	cards.add(p1, "Panel 1");
    	ViewChef objvc = new ViewChef(10);
    	p2 = objvc.getMainJPanel();    	
    	cards.add(p2, "Panel 2");   	
    	System.out.println("Test");    
    	f.add(cards, BorderLayout.CENTER);
    	f.setSize(550, 450);
        //f.add(control, BorderLayout.SOUTH);
        f.pack();
       // f.setLocationRelativeTo(null);
        f.setVisible(true);
    	
        
    }   
    
    
    public JPanel getCards() {
    	return cards;
    }

    
    

}
