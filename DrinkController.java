package edu.colostate.cs.cs414c.webservice;
import edu.colostate.cs.cs414c.model.Drink;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import com.sun.net.httpserver.HttpExchange;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
public class DrinkController implements HttpHandler {
	private Set<String> drinks;
	private Set<String> drinksize;
	public DrinkController(){
		drinks = new HashSet<String>();
		drinksize = new HashSet<String>();
		
	}
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		//this is the URL of the request
		URI uri = exchange.getRequestURI();
		
		//the URL could come with parameters
		String query = uri.getQuery();
		if (query != null)
		{
			//if the url has parameters, we need to parse them 
			//parseQuery(query);
		}
		
		//get the XML response
		String response = getXml();
		//send the response
		//200 means the request was successful 
		exchange.sendResponseHeaders(200, response.length());

		//output the information
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}	
	
	
	private String getXml(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buffer.append("<drinks>");
		buffer.append("<drink>");
		buffer.append("<drinkname>");
		for(String drinkname : drinks){
			buffer.append("<drinknamedes>"+drinkname+"</drinknamedes>");
			buffer.append("\n");
		}
		buffer.append("</drinkname>");
		buffer.append("<drinksize>");
		for(String drink : drinksize){
			buffer.append("<drinksizedes>"+drink+"</drinksizedes>");
			buffer.append("\n");
		}
		buffer.append("</drinksize>");
		buffer.append("</drink>");
		buffer.append("</drinks>");
		return buffer.toString();
	}
	
	public void generateDrink(){
		Drink d1 = new Drink();
		drinks = d1.getAllDrink();
		drinksize = d1.getListofDrinkSize();
	}
	
}
