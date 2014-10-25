package edu.colostate.cs414c.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */
public class Login {
	
	public EmployeeDetails authenticate(String userid, String pwd){
		EmployeeDetails user = null;
		for(EmployeeDetails li : PizzaStore.getInstance().getEmployeesList()){
			if(li.getId().equals(userid) && li.getPassword().equals(pwd)){
				user=li;
				break;
			}
		}
		return user;
	}
}

