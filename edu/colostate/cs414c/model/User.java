package edu.colostate.cs.cs414c.model;

public abstract class User {
	
	private String name;
	private String userName;
	private String userPassword;
	

	public User(String name, String userName, String userPassword){
		this.name = name;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public User(String userName, String userPassword){
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public User(){
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setUserName (String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	
	public String getUserPassword(){
		return this.userPassword;
	}
	
	public abstract void addUser();
	
}
