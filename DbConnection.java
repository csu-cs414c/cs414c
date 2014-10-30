package edu.colostate.cs.cs414c.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DbConnection {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  
	  private ResultSet resultSet = null;
	
		
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
	
	public Set<String> getListOfPizzas() {
		Set<String> pizzaList = new HashSet<String>();
		try {
			resultSet = statement.executeQuery("select name from pizza order by p_id");
			while (resultSet.next()) {
				int numberOfColumns = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= numberOfColumns; i++) {
					pizzaList.add(resultSet.getObject(i).toString());
					
				}
			}
			return pizzaList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pizzaList;
		}
	}
	
	public Set<String> getListOfDrinks() {
		Set<String> drinkList = new HashSet<String>();
		try{
			resultSet = statement.executeQuery("select name from drink");
			while (resultSet.next()) {
				int numberOfColumns = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= numberOfColumns; i++) {
					drinkList.add(resultSet.getObject(i).toString());
					
				}
			}
			
			return drinkList;
		}catch(SQLException e){
			e.printStackTrace();
			return drinkList;
		}
	}
	
	public Set<String> getListOfAddOn(){
		Set<String> addOnList = new HashSet<String>();
		try{
			resultSet = statement.executeQuery("select name from addon");
			while (resultSet.next()) {
				int numberOfColumns = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= numberOfColumns; i++) {
					
					addOnList.add(resultSet.getObject(i).toString());
					
				}
			}
			
			return addOnList;
			
		}catch(SQLException e){
			e.printStackTrace();
			return addOnList;
		}
	}
	
	public float getDrinkPrice(String size){
		float price = 0.0f;
		try{
			System.out.println("size is "+size);
			resultSet = statement.executeQuery("select price from drinksize where size = '"+size+"'");
			while (resultSet.next()) {
				price = Float.parseFloat((resultSet.getObject(1).toString()));
				System.out.println("Size is "+size +" Price is "+price);
			}
			
			return price;
			
		}catch(SQLException e){
			e.printStackTrace();
			return price;
		}
	}
	
	public float getAddOnPrice(String addOn){
		float price = 0.0f;
		try{
			System.out.println("size is "+addOn);
			resultSet = statement.executeQuery("select price from addon where name = '"+addOn+"'");
			while (resultSet.next()) {
				price = Float.parseFloat((resultSet.getObject(1).toString()));
				System.out.println("Size is "+addOn +" Price is "+price);
			}
			
			return price;
			
		}catch(SQLException e){
			e.printStackTrace();
			return price;
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
	
	public Set<String> getAllToppings() {
		
		Set<String> toppingList = new HashSet<String>();
		try {
			resultSet = statement
					.executeQuery("select distinct(name) from toppings");
			
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
	
	public boolean setDealOfDay(String pizzaname,String drinkname,String addonname, float price){
		boolean dealset = false;
		
		try{
			statement
					.executeUpdate("insert into dealofday (id,pizzaname,drinkname,addonname,price) values (null,\""+pizzaname+"\",\""+drinkname+"\",\""+addonname+"\","+price+")");
			resultSet = statement.executeQuery("select * from dealOfDay");
			boolean val = resultSet.next();
			return val;
			
		}catch(Exception e){
			e.printStackTrace();
			return dealset;
		}
	}
	
	
	
	public Map<String, String> getDealOfDay(){
		Map<String, String> dealOfDay = new HashMap<String, String>();
		String[] columnNames = {"pizzaname","drinkname","addonname","price"};
		try{
			for(int i=0;i<columnNames.length;i++){
				//System.out.println("Coulmn name is "+columnNames[i]);
				resultSet = statement
						.executeQuery("select "+columnNames[i]+" from dealofday");
				while (resultSet.next()) {
					
					dealOfDay.put(columnNames[i],resultSet.getObject(1).toString());
				}
					
			}
			return dealOfDay;
		}catch(Exception e){
			e.printStackTrace();
			return dealOfDay;
		}
	}
	
	public boolean deleteDealOfDay(){
		boolean message = false;
		try{
			statement
					.execute("delete  from dealOfDay where id >0");
			resultSet = statement.executeQuery("select * from dealOfDay");
			boolean val = resultSet.next();
			return val;
		}catch(Exception e){
			e.printStackTrace();
			return message;
		}
	}
	
	
	
	public boolean modifyPizzaPrice(String item, float price){
		try{
			statement
					.executeUpdate("update pizza set price = "+price+" where name = \""+item+"\"");
			resultSet = statement.executeQuery("select price from pizza where name =\""+item+"\"");
			while (resultSet.next()) {
				float value = Float.parseFloat(resultSet.getObject(1).toString());
				if(value == price){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modifydrinkSizePrice(String item, float price){
		try{
			statement
					.executeUpdate("update drinksize set price = "+price+" where size = \""+item+"\"");
			resultSet = statement.executeQuery("select price from drinksize where size =\""+item+"\"");
			while (resultSet.next()) {
				float value = Float.parseFloat(resultSet.getObject(1).toString());
				if(value == price){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modifyAddOnPrice(String item, float price){
		try{
			statement
					.executeUpdate("update addon set price = "+price+" where name = \""+item+"\"");
			resultSet = statement.executeQuery("select price from addon where name =\""+item+"\"");
			while (resultSet.next()) {
				float value = Float.parseFloat(resultSet.getObject(1).toString());
				if(value == price){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args){
		DbConnection db = new DbConnection();
		db.modifyAddOnPrice("Bread Stick", 3.00f);
	}

   
}
