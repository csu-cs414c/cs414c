package edu.colostate.cs414c.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */

import java.util.ArrayList;


public class PizzaStore {
	
	private String name = "Pizza Place";
	private String address = "CSU";
	private ArrayList<EmployeeDetails> employeesList = new ArrayList<EmployeeDetails>();
	private static PizzaStore pizzastore = new PizzaStore();
	
	public static void main(String args[]){
		
		PizzaStore.getInstance().hireEmployees();
	}
	
	public void hireEmployees(){
		EmployeeDetails emp1 = new EmployeeDetails();
		emp1.setName("Qwerty");
		emp1.setPhone("9702341214");
		emp1.setId("manager");
		emp1.setPassword("man");
		emp1.setJoiningDate("09/2011");
		emp1.setRole("manager");
		emp1.setSalary(3000);
		
		EmployeeDetails emp2 = new EmployeeDetails();
		emp2.setName("Asdf");
		emp2.setPhone("9703244383");
		emp2.setId("cashier");
		emp2.setPassword("cash");
		emp2.setJoiningDate("07/2012");
		emp2.setRole("cashier");
		emp2.setSalary(2500);
		
		EmployeeDetails emp3 = new EmployeeDetails();
		emp3.setName("Tina");
		emp3.setPhone("9702346534");
		emp3.setId("chef");
		emp3.setPassword("cook");
		emp3.setJoiningDate("11/2010");
		emp3.setRole("chef");
		emp3.setSalary(6000);
		
		getInstance().employeesList.add(emp1);
		getInstance().employeesList.add(emp2);
		getInstance().employeesList.add(emp3);
	}
	
	public static PizzaStore getInstance(){
		return pizzastore;
	}

	public ArrayList<EmployeeDetails> getEmployeesList() {
		return employeesList;
	}

	public void addEmployeesList(EmployeeDetails employeeDetails) {
		employeesList.add(employeeDetails);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public String getRole(String user){
		for (EmployeeDetails emp : employeesList){
			if(emp.getName().equals(user)){
				return emp.getRole();
			}
		}
		return "none";
	}
	
}


