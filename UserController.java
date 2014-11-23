package edu.colostate.cs.cs414c.webservice;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import edu.colostate.cs.cs414c.model.Customer;
import edu.colostate.cs.cs414c.model.Login;
import edu.colostate.cs.cs414c.model.Store;

public class UserController implements HttpHandler{
	
	private Customer cust;
	
	public UserController(){
		cust = new Customer();
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String type = null;
		URI uri = exchange.getRequestURI();
		
		//the URL could come with parameters
		String query = uri.getQuery();
		if (query != null)
		{
			//if the url has parameters, we need to parse them 
			System.out.println("Into here");
			type = parseQuery(query);
		}
		
		//get the XML response
		String response = getXml(type);
		//send the response
		//200 means the request was successful 
		exchange.sendResponseHeaders(200, response.length());

		//output the information
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
		
	}
	
	private String parseQuery(String query){
		
		System.out.println("Query is "+query);
		String name = null;
		String password = null;
		String itemType = query.substring(query.indexOf("type=")+5, query.indexOf("&name"));
		
		
		
		if(itemType.equals("customer")){
			
			Login login= new Login();
			System.out.println("Item type is -- "+itemType);
			String[] subs = query.split("&");
			
			for(String parameter:subs){
				String[] values = parameter.split("=");
				if(values[0].equals("name")){
					
					name = values[1];
					System.out.println("Name : "+name);
				}else if(values[0].equals("password")){
					
					password = values[1];
					System.out.println("password : "+password);
				}
				
			}
			cust = login.validateUser(name, password);
			
			return "customer";
		}else if(itemType.equals("store")){
			System.out.println("Item type is -- "+itemType);
			
			//String[] subs = query.split("&");
			
			/*for(String parameter:subs){
				String[] values = parameter.split("=");
				if(values[0].equals("all")){
					
				}
			}*/
			
			return "store";
		}
		return null;
	}
	
	public String getXml(String type){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		if(type.equals("customer")){
			if(cust.getLoginStatus()){
				buffer.append("<customer>");
				buffer.append("<name>");
				buffer.append(cust.getName());
				buffer.append("</name>");
				buffer.append("<address1>");
				buffer.append(cust.getAddress1());
				buffer.append("</address1>");
				buffer.append("<address2>");
				buffer.append(cust.getAddress2());
				buffer.append("</address2>");
				buffer.append("<city>");
				buffer.append(cust.getCity());
				buffer.append("</city>");
				buffer.append("<state>");
				buffer.append(cust.getState());
				buffer.append("</state>");
				buffer.append("<zip>");
				buffer.append(cust.getZip());
				buffer.append("</zip>");
				buffer.append("<phone>");
				buffer.append(cust.getPhone());
				buffer.append("</phone>");
				buffer.append("<email>");
				buffer.append(cust.getEmail());
				buffer.append("</email>");
				buffer.append("<points>");
				buffer.append(cust.getPoints());
				buffer.append("</points>");
				buffer.append("</customer>");
			}else{
				buffer.append("<customer>");
				buffer.append("<message>");
				buffer.append("Invalid Username/password");
				buffer.append("</message>");
				buffer.append("</customer>");
			}
		}else if(type.equals("store")){
			Set<Hashtable<String, String>> stores = new HashSet<Hashtable<String,String>>();
			Set<String> storeAtt = null;
			Hashtable<String, String> keyvaluepair = new Hashtable<String, String>();
			String key = null;
			Store store = new Store();
			stores = store.getAllStores();
			
			
			Iterator<Hashtable<String, String>> itr = stores.iterator();
			buffer.append("<stores>");
			while(itr.hasNext()){
				keyvaluepair = itr.next();
				storeAtt = keyvaluepair.keySet();
				Iterator<String> itr1 = storeAtt.iterator();
				buffer.append("<store>");
				
				while(itr1.hasNext()){
					key = itr1.next().toString();
					buffer.append("<"+key+">");
					buffer.append(keyvaluepair.get(key));
					buffer.append("</"+key+">");
				}
				buffer.append("</store>");
			}
			
			buffer.append("</stores>");
			
			
		}
		
		
		return buffer.toString();
	}

}
