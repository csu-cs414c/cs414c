package edu.colostate.cs.cs414c.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import edu.colostate.cs.cs414c.model.Toppings;


public class DbConnection {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	
	public static void main(String[] argv) throws Exception {
		
		DbConnection test = new DbConnection(); 
		test.getConnection();
		test.getListOfPizzas();
		test.getListOfToppins("Cheese Pizza");
		test.getBase("Cheese Pizza");
		
	}
	
	public DbConnection(){
		getConnection();
	}
	
	public void getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cs414c?user=root&password=admin");
			statement = connect.createStatement();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
				
		}
	}
	
	public Map<String,String> getListOfUsers(){
		Map<String, String> userNamePassword = new HashMap<String, String>();
		//TBD
		return userNamePassword;
	}
	
	public void addUser(String userName, String password){
		// TBD
	}
	
	public String[] getListOfPizzas() {
		String[] pizzaList = null;
		try {
			resultSet = statement.executeQuery("select name from pizza");
			while (resultSet.next()) {
				int numberOfColumns = resultSet.getMetaData().getColumnCount();
				pizzaList = new String[numberOfColumns];
				for (int i = 1; i <= numberOfColumns; i++) {
					pizzaList[i - 1] = resultSet.getObject(i).toString();
					
				}
			}
			return pizzaList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pizzaList;
		}
	}

	public Set<String> getListOfToppins(String pizzaName) {
		
		Set<String> toppingList = new HashSet<String>();
		try {
			resultSet = statement
					.executeQuery("select name from toppings where p_id in (select p_id from pizza where name='"
							+ pizzaName + "')");
			
			while (resultSet.next()) {
								
				
				toppingList.add(resultSet.getObject(1).toString());
			}
			
			return toppingList;
		} catch (SQLException e) {
			e.printStackTrace();
			return toppingList;
		}
	}
	
	public String getBase(String pizzaName) {
		String baseList = null;
		try {
			resultSet = statement
					.executeQuery("select name from base where p_id in (select p_id from pizza where name='"
							+ pizzaName + "')");
			while (resultSet.next()) {
				int numberOfColumns = resultSet.getMetaData().getColumnCount();
				if (numberOfColumns == 1) {
					baseList = resultSet.getObject(1).toString();
					
				}
			}

			return baseList;
		} catch (SQLException e) {
			e.printStackTrace();
			return baseList;
		}
	}
	
	
	public float getPizzaItemsPrice(String name){
		System.out.println("Name is "+ name);
		float toppingPrice = 0;
		try{
			resultSet = statement
					.executeQuery("select price from itemprice where name = '"+name+"'");
			while (resultSet.next()) {
				toppingPrice = Float.parseFloat(resultSet.getObject(1).toString());
			}
			return toppingPrice;
		}catch(Exception e){
			e.printStackTrace();
			return toppingPrice;
		}
	}
	
	public float getPizzaPrice(String name){
		float pizzaPrice = 0;
		try{
			resultSet = statement
					.executeQuery("select price from pizza where name = \""+name+"\"");
			while (resultSet.next()) {
				pizzaPrice = Float.parseFloat(resultSet.getObject(1).toString());
			}
			return pizzaPrice;
		}catch(Exception e){
			e.printStackTrace();
			return pizzaPrice;
		}
	}

   
}
