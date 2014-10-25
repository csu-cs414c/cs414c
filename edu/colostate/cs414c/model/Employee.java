package edu.colostate.cs.cs414c.model;

public class Employee extends User{

	private int employeeId;
	private Roles role; 
	
	
	public enum Roles {
		
		admin,
		cashier,
		chef
		
	}
	
	public void setRole(Roles role){
		this.role = role;
	}
	
	public Roles getRole(){
		return this.role;
	}
	
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}
	
	public int getEmployeeId(){
		return this.employeeId;
	}

	@Override
	public void addUser() {
		if(getRole().equals(Roles.admin)){
			// TBD
		}
		
	}

}

