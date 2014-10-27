/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.colostate.cs414c.model;

/**
 *
 * @author pavithra
 */


import edu.colostate.cs414c.controller.ManagerController;

public class Manager {

	public Manager(String user){
		new ManagerController(user);
	}
}


