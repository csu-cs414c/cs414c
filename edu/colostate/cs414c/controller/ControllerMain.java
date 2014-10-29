package chef;

import java.awt.EventQueue;

public class ControllerMain {	
	
	public ControllerMain() {
		new ControllerChefOrderList();
		new ControllerChef();
		new ViewMain();
	}
	
	public static void main(String args[])
    {
    	 EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {             	
                new ControllerMain();
             }
         });                 
         
    }
}
