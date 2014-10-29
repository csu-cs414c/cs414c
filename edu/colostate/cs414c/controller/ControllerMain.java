package edu.colostate.cs.cs414c.controller;

import java.awt.EventQueue;

import edu.colostate.cs.cs414c.view.ViewMain;

public class ControllerMain {	
	
	public ControllerMain() {
		ViewMain objviewmain = new ViewMain();
		new ControllerAddSaleLineItem(objviewmain);
		
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
