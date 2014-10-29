/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pavithra
 */
public class AddUserView extends JFrame{
    JFrame f = new JFrame();
    JLabel name,phone,id,password,role,salary;
    JTextField namefield = new JTextField(20);
    JTextField phonefield = new JTextField(15);
    JTextField idfield = new JTextField(10);
    JPasswordField passwordfield = new JPasswordField(20);
    JTextField salaryfield = new JTextField(10);
    JButton ok, cancel,back;
    String[] rolelist = {"manager", "cashier", "chef", "customer"};
    JComboBox rolebox;
    private String msg = "employee added";
    
    
    public AddUserView()    {  
       name = new JLabel("name");
       phone = new JLabel("phone");
       role = new JLabel("role");
       id = new JLabel("username");
       password = new JLabel("password");
       salary = new JLabel("salary");
       ok = new JButton("ok");
       cancel = new JButton("cancel");
       back = new JButton("back");
       rolebox = new JComboBox(rolelist);
       rolebox.setSelectedIndex(0);
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,700);
	this.add(panel);
	panel.setLayout(null);
	setBounds();
	addtoPanel(panel);
        f.setTitle("User Management");
	//this.setVisible(true);
        f.add(panel);
        f.setSize(450, 550);
        f.setVisible(true);
        
	}

	public void addtoPanel(JPanel panel){
		panel.add(name);
                panel.add(namefield);
		panel.add(phone);
                panel.add(phonefield);
		panel.add(id);
                panel.add(idfield);
		panel.add(password);
                panel.add(passwordfield);
		panel.add(role);     
		panel.add(rolebox);
                panel.add(salary);
                panel.add(salaryfield);
                panel.add(ok);
                panel.add(cancel);
                panel.add(back);
                    
    
}
        public void setBounds() {
              
		name.setBounds(100, 100, 100,25);
		namefield.setBounds(200, 100, 100,25);
		phone.setBounds(100,140,100,25);
		phonefield.setBounds(200,140, 100,25);
                id.setBounds(100,180,100,25);
                idfield.setBounds(200,180,100,25);
                password.setBounds(100,220,100,25);
                passwordfield.setBounds(200,220,100,25);
                role.setBounds(100,260,100,25);
                rolebox.setBounds(200,260,100,25);
                salary.setBounds(100,300,100,25);
                salaryfield.setBounds(200,300,100,25);
                ok.setBounds(100,400,100,25);
                cancel.setBounds(200,400,100,25);
		
        }
        public String getUserField() {
		return idfield.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPwdField() {
		return passwordfield.getText();
	}
        
        public String getPhone()    {
            return phonefield.getText();
        }
        
        public String getName() {
            return namefield.getText();
        }
	 
        public String getSalary()  {
            return salaryfield.getText();
        }
        
        public JButton getok()  {
            return ok;
        }
        
        public JButton getcancel()  {
            return cancel;
        }
        
        public JComboBox getrole()   {
            return rolebox;
        }
        
        public JButton getBack()    {
            return back;
        }
	public void ButtonListener(ActionListener l){
                rolebox.addActionListener(l);
		ok.addActionListener(l);
                cancel.addActionListener(l);
                back.addActionListener(l);
	} 
        
        public void textMsg(){
		JOptionPane.showMessageDialog(this,msg);
	}
       
}

