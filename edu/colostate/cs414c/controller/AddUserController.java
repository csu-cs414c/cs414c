/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.controller;

import edu.colostate.cs414c.model.EmployeeDetails;
import edu.colostate.cs414c.model.Login;
import edu.colostate.cs414c.model.PizzaStore;
import edu.colostate.cs414c.view.AddUserView;
import edu.colostate.cs414c.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author pavithra
 */
public class AddUserController {
 	private AddUserView user;
	private EmployeeDetails ed;
        String rolename;
	public AddUserController(){
		this.user = new AddUserView();
		System.out.println("test");
		this.user.ButtonListener(new AddUserListener());
	}


	class AddUserListener implements ActionListener{
            @Override
		public void actionPerformed(ActionEvent e) {
                ed = new EmployeeDetails();
                //JcomboBox cb= (JComboBox) e.getSource();
                if(e.getSource() == user.getrole() )    {
                    JComboBox cb = (JComboBox)e.getSource();
                    rolename = (String)cb.getSelectedItem();
                    System.out.println("rolename" + rolename);
                }
              if(e.getSource() == user.getok())   {
                    
			String userid,pwd,phone,name;
                        int salary;
			userid = user.getUserField();
			pwd = user.getPwdField();
                       // JComboBox cb = (JComboBox)e.getSource();
                        //String rolename = (String)cb.getSelectedItem();
                        name = user.getName();
                        phone = user.getPhone();
                        salary = Integer.parseInt(user.getSalary());
                      
                          ed.setName(name);
                          ed.setId(userid);
                          ed.setPassword(pwd);
                          ed.setPhone(phone);
                          ed.setRole(rolename);
                          ed.setSalary(salary);
                          PizzaStore.getInstance().addEmployeesList(ed);
                          user.textMsg();
                }
                
              else  if(e.getSource() == user.getcancel())   {
                   // new ManagerController();
                  user.setVisible(false);
                    new ManagerController("manager");
                }
              else if(e.getSource() == user.getBack())  {
                  user.setVisible(false);
                  new ManagerController("manager");
              }
                        
     
        }

}
         public static void main(String args[])  {
            new AddUserController();
        }
}
