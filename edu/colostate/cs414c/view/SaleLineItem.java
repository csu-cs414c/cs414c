/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author pavithra
 */
public class SaleLineItem extends JPanel {
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 =new JPanel();
    JButton additem, removeitem,submit,cancel;
    JLabel cost,orderid, cust_name;
    JTextField item = new JTextField(30);
    JTextField value = new JTextField(30); 
    //JFrame f;
    private JTextField custNameField = new JTextField(25);
    private JTextField orderfield = new JTextField(25);
    
     public void addtoPanel(JPanel panel) {
        
      //panel.setLayout(new GridLayout());
         panel.setSize(1000, 500);
       orderid = new JLabel("order id");
       panel.add(orderid, BorderLayout.NORTH);
       panel.add(orderfield, BorderLayout.NORTH);
       cust_name = new JLabel("customer name");
       panel.add(cust_name,BorderLayout.LINE_END);
       panel.add(custNameField,BorderLayout.LINE_END);
      
       
       panel.setVisible(true);
       //f.add(panel);
    }
     
     public void addtoPanel2(JPanel panel2) {
          panel2.add(item,BorderLayout.CENTER);
       additem = new JButton(" + ");
       panel2.add(additem);
       removeitem = new JButton(" - ");
       panel2.add(removeitem);
       cost = new JLabel("Total cost");
       panel2.add(cost);
       panel2.add(value);
       submit = new JButton("submit");
       panel2.add(submit);
       cancel =new JButton("cancel");
       panel2.add(cancel);
      
     }
     
     public void setBounds()
     {
                cust_name.setBounds(270,80,150,25);
		custNameField.setBounds(300,80,100,25);
                orderid.setBounds(120,200,150,25);
		orderfield.setBounds(300,200,100,25);
                
                cancel.setBounds(280,600,100,25);
		submit.setBounds(400,600,100,25);
                



     }
    
    public SaleLineItem(){   
 //f = new JFrame();
     //   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setSize(1000,1000);
        //f.setTitle("SaleLineItem");
        addtoPanel(panel);
        addtoPanel2(panel2);
        panel3.add(panel);
        panel3.add(panel2);
        //f.isResizable();
        //setBounds();
       // f.setContentPane(panel);
        //f.add(panel);
       // f.pack();
       // f.setVisible(true);
      
    }
   
    public void buttonListener(ActionListener l)
    {
        item.addActionListener(l);
        additem.addActionListener(l);
        removeitem.addActionListener(l);
        submit.addActionListener(l);
        cancel.addActionListener(l);
    }
    
    public JPanel getPanel()    {
        return panel3;
    }
    
    public JButton getaddItem() {
        return additem;
    }
    
    public JButton getremoveItem()  {
        return removeitem;
    }
    
    public JButton getsubmit()  {
        return submit;
    }
    
    public JButton getcancel()  {
        return cancel;
    }
    
    
    
    public static void main(String args[]){
        new SaleLineItem();
       
    }
  
}
