package chef;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControllerChefOrderList {
	ViewChefOrderList objvcol;
	
	public ControllerChefOrderList() {
		this.objvcol = new ViewChefOrderList();
		objvcol.activateListener(new ChefOrderListListener());
	}
	
	class ChefOrderListListener implements ActionListener {
		//private JFrame jframe;
		//private JPanel jpanel;
		ViewMain objviewmain = new ViewMain();
		@Override
		public void actionPerformed(ActionEvent al) {
			System.out.println("ActionListener");
			JButton button = (JButton)al.getSource();
			if(button.equals(objvcol.getChefViewOrderButton())) {
				System.out.println("inside");
				CardLayout cl = (CardLayout) objviewmain.getCards().getLayout();
				cl.show(objviewmain.getCards(), "Panel 2");
				
				
			} 			
		}
		
	}
}
