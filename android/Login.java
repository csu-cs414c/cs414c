package edu.colostate.cs.cs414c.model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import edu.colostate.cs.cs414c.utils.DbConnection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */
public class Login {
	private String userName;
	private String password;
	private DbConnection db;
	
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
	
	public Login(){
		db = new DbConnection();
	}
	
	public Login(String userName,String password){
		this.userName = userName;
		this.password = password;
		db = new DbConnection();
	}
	
	public Customer validateUser(String userName,String password){
		Hashtable<String, String> userDetails = new Hashtable<String, String>();
		Customer customer = new Customer();
		if(db.validateUser(userName, password)){
			userDetails = db.getUserDetails(userName);
			customer.setName(userDetails.get("name"));
			customer.setAddress1(userDetails.get("address1"));
			customer.setAddress2(userDetails.get("address2"));
			customer.setCity(userDetails.get("city"));
			customer.setState(userDetails.get("state"));
			customer.setZip(userDetails.get("zip"));
			customer.setPhone(userDetails.get("phone"));
			customer.setEmail(userDetails.get("email"));
			customer.setPoints(userDetails.get("points"));
			customer.setLoginStatus(true);
		}else{
			customer.setLoginStatus(false);
		}
		
		return customer;
	}
	
	public static void main(String[] args){
		Login login = new Login();
		login.validateUser("leo", "leo123");
	}
	
}

