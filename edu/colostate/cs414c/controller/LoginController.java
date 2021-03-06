package edu.colostate.cs414c.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.colostate.cs414c.model.Cashier;
import edu.colostate.cs414c.model.EmployeeDetails;
import edu.colostate.cs414c.model.Login;
import edu.colostate.cs414c.model.Manager;
import edu.colostate.cs414c.view.LoginView;

public class LoginController {

	private LoginView lview;
	private LoginModel lmodel;

	public LoginController(){
		this.lview = new LoginView();
		this.lmodel = new LoginModel();

		this.lview.ButtonListner(new LoginListner());
	}

	class LoginListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String userid,pwd;
			userid = lview.getUserField();
			pwd = lview.getPwdField();
			EmployeeDetails user=lmodel.authenticate(userid, pwd); 
			if(user==null){
				lview.errorMsg();
			}
			else if (user.getRole().equals("manager")){
				new Manager(user.getName());
				lview.setVisible(false);
			}
			else if (user.getRole().equals("cashier")) {
				new Cashier(user.getName());
				lview.setVisible(false);
			}
			else if(user.getRole().equals("chef")){
				new ChefController(user.getName());
				lview.setVisible(false);
			}
		}
	}
	
}


