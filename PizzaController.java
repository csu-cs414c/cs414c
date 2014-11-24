package edu.colostate.cs.cs414c.webservice;
import edu.colostate.cs.cs414c.model.Pizza;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

//Basic web service for a PizzaController
public class PizzaController implements HttpHandler {
	private Set<String> pizzas; //has a list of all pizzas
	private Set<String> pizzabase; //has list of all pizzabase 
	private Set<String> pizzasize;
	private Set<String> pizzatoppings; 
	Multimap<String, String> toppingsforapizza; //has list of all toppings independant of pizza
	//constructor initializes array list
	public PizzaController()
	{
		pizzas = new HashSet<String>();
		pizzabase = new HashSet<String>();
		pizzasize = new HashSet<String>();
		pizzatoppings = new HashSet<String>();
		toppingsforapizza = HashMultimap.create(); 
	}

	//this function is called when an HTTP request is made
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
	
	//parses the parameters from the URL
	//these are in the form {base_url}?customer=name&size=pizza_size&toppings=t1-t2-..-tn
	/*private void parseQuery(String query) {
		//split the query based on parameters
		String[] subs = query.split("&");
		String customer = null;
		Pizza.Size size = null;
		ArrayList<Pizza.Toppings> toppings = null;
		
		for (String parameter : subs)
		{	
			//key is on the left and value is on the right, so we split this
			String[] values = parameter.split("=");
			if (values[0].equals("customer"))
			{
				customer = values[1];
			}
			else if (values[0].equals("size"))
			{
				size = Pizza.Size.valueOf(values[1]);
			}
			else if (values[0].equals("toppings"))
			{
				//there are n toppings separated by "-", so we split that
				toppings = new ArrayList<Pizza.Toppings>();
				String[] tops = values[1].split("-");
				for (String t : tops)
				{
					toppings.add(Pizza.Toppings.valueOf(t));
				}
			}
		}
		
		if (customer != null && size != null && toppings != null)
		{
			//if we have a valid pizza, we output it to the log
			Pizza pizza = new Pizza(customer, size, toppings);
			System.out.println("Added pizza: customer=" + customer + " size=" + size + " toppings=" + toppings);
			pizzas.add(pizza);
		}
	}*/


	//Turns the ArrayList<Pizza> into an XML representation
	private String getXmlold() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buffer.append("<pizzas>");
		buffer.append("<pizza>");
		for (String pizzaname : pizzas)
			{
				buffer.append("<name>" + pizzaname + "</name>");
				buffer.append("\n");
			}

			buffer.append("</pizza>");
		buffer.append("</pizzas>");

		return buffer.toString();
	}
	
	private String getXml() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buffer.append("<pizzas>");
		buffer.append("<pizza>");
		for (String pizzaname : toppingsforapizza.keySet())
			{
				buffer.append("<pizzaname>" + pizzaname + "</pizzaname>");
				System.out.println("Pizza Name: "+pizzaname);
				Set<String> temptoppingset = (Set)toppingsforapizza.get(pizzaname);
				//System.out.println("temptoppingset size: "+temptoppingset.size());
				for(String topping: temptoppingset){
					System.out.println("Pizza Topping: "+topping);
					buffer.append("<pizzatopping>" + topping + "</pizzatopping>");
					buffer.append("\n");
				}
				buffer.append("\n");
			}

		buffer.append("</pizza>");
		buffer.append("<base>");
		for(String basename : pizzabase){
			System.out.println("base: "+basename);
			buffer.append("<basename>"+basename+"</basename>");
			buffer.append("\n");
		}
		buffer.append("</base>");
		
		buffer.append("<size>");
		for(String sizename : pizzasize){
			System.out.println("base: "+sizename);
			buffer.append("<sizename>"+sizename+"</sizename>");
			buffer.append("\n");
		}
		buffer.append("</size>");
		
		buffer.append("<topping>");
		for(String toppingname : pizzatoppings){
			System.out.println("topping: "+toppingname);
			buffer.append("<toppingname>"+toppingname+"</toppingname>");
			buffer.append("\n");
		}
		buffer.append("</topping>");
		
		buffer.append("</pizzas>");

		return buffer.toString();
	}

	//adds some pizzas to the list so we don't start with an empty list
	public void generatePizza()
	{
		Pizza p1 = new Pizza();
		pizzas = p1.getAllPizza();
		pizzabase = p1.getAllBases();
		pizzasize = p1.getAllSizes();
		pizzatoppings = p1.getAllToppings();
		toppingsforapizza = p1.populateToppingsforaPizza();
		
	}

	//important main method is needed to run the server
	public static void main(String[] args) throws IOException {

		//creates the server on port 8,000
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 8000);
		
		//create the pizza controller
		PizzaController PC = new PizzaController();
		DrinkController DC = new DrinkController();
		AddonController AC = new AddonController();
		PaymentController payment = new PaymentController();
		
		//populate with initial pizzas
		PC.generatePizza();
		DC.generateDrink();
		AC.generateAddon();
		
		//creates the URI for the pizza. In this case, {base}/pizzas redirects here
		server.createContext("/pizzamenu", PC);
		server.createContext("/drinkmenu", DC);
		server.createContext("/addonmenu", AC);
		server.createContext("/payment",payment);
		
		//start the server
		server.start();
	}

}
