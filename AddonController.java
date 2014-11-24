package edu.colostate.cs.cs414c.webservice;
import edu.colostate.cs.cs414c.model.AddOn;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
public class AddonController implements HttpHandler {
	private Set<String> addon;
	public AddonController(){
		addon = new HashSet<String>();
		
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
		buffer.append("<addons>");
		buffer.append("<addon>");
		for(String addonname : addon){
			buffer.append("<addonname>"+addonname+"</addonname>");
			buffer.append("\n");
		}
		buffer.append("</addon>");
		buffer.append("</addons>");
		return buffer.toString();
	}
	
	public void generateAddon(){
		AddOn a1 = new AddOn();
		addon = a1.getAllAddon();
	}
	
}
