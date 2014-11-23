package edu.colostate.cs.cs414c.webservice;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import edu.colostate.cs.cs414c.model.AddOn;
import edu.colostate.cs.cs414c.model.Discounts;
import edu.colostate.cs.cs414c.model.Drink;
import edu.colostate.cs.cs414c.model.Item;
import edu.colostate.cs.cs414c.model.Pizza;
import edu.colostate.cs.cs414c.model.Sale;
import edu.colostate.cs.cs414c.model.SaleLineItem;

//Basic web service for a PizzaController
public class PaymentController implements HttpHandler {
	
	private String itemType;
	private SaleLineItem lineItem;
	private Set<SaleLineItem> saleLineItems = new HashSet<SaleLineItem>();
	private Sale sale;
	private Pizza pizza;
	private Drink drink;
	private AddOn addon;
	float amount = 0.0f;
	
	public PaymentController()
	{
		
	}

	//this function is called when an HTTP request is made
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("called");
		//this is the URL of the request
		URI uri = exchange.getRequestURI();
		
		//the URL could come with parameters
		String query = uri.getQuery();
		if (query != null)
		{
			//if the url has parameters, we need to parse them 
			System.out.println("Into here");
			itemType =parseQuery(query);
		}
		
		//get the XML response
		String response = getXml(itemType);
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
	private String parseQuery(String query) {
		String name = null;
		System.out.println("query "+query);
		String itemType = query.substring(query.indexOf("item=")+5, query.indexOf("&name"));
		if(!itemType.equals("discount")){
			
						
			System.out.println("itemType is ---"+itemType);
			if(itemType.equals("delete")){
				name = query.substring(query.indexOf("name")+5,query.length());
			}else{
				name = query.substring(query.indexOf("name=")+5, query.indexOf("&quantity"));
			}
			System.out.println("itemname = "+ name);
			String[] subs = query.split("&");
			
			Set<String> userSelectedToppings = new HashSet<String>();
			String pizzaSize = null;
			String pizzaCrust = null;
			int quantity = 1;
			String drinkSize = null;
			
			
			System.out.println("Query is : "+query);
			
			if(itemType.equals("pizza")){
				
				pizza = new Pizza(name);
				
				for(String parameter:subs){
					
					String[] values = parameter.split("=");
					if(values[0].equals("toppings")){
						String toppings[] = values[1].split("-");
						for(String topp: toppings){
							userSelectedToppings.add(topp);
						}
						System.out.println("toppings number is... "+toppings.length);
						pizza.setUserSelectedToppings(userSelectedToppings);
					}else if(values[0].equals("size")){
						pizzaSize = values[1];
						pizza.setSize(pizzaSize);
						System.out.println("Base size is .. "+pizzaSize);
					}else if(values[0].equals("base")){
						pizzaCrust = values[1];
						pizza.setCrust(pizzaCrust);
						System.out.println("crust name is .. "+pizzaCrust);
					}else if(values[0].equals("quantity")){
						quantity = Integer.parseInt(values[1]);
						pizza.setQuanitity(quantity);
						System.out.println("quantity is "+quantity);
					}
				}
				amount = pizza.calculatePizzaPrice(userSelectedToppings.size(), pizzaSize,pizzaCrust, quantity);
				pizza.setPrice(amount);
				lineItem = new SaleLineItem(name, quantity, amount);
				saleLineItems.add(lineItem);
				System.out.println("final amount "+amount);
				
			}else if(itemType.contains("drink")){
				drink = new Drink();
				drink.setName(name);
				System.out.println("Into Drink");
				for(String parameter:subs){
					String[] values = parameter.split("=");
					if(values[0].equals("size")){
						drinkSize = values[1];
						drink.setSize(drinkSize);
						System.out.println("drink size "+drinkSize);
					}else if(values[0].equals("quantity")){
						quantity = Integer.parseInt(values[1]);
						drink.setQuantity(quantity);
						System.out.println("drink quanitity"+quantity);
					}
				}
				amount = drink.calculateDrinkPrice(quantity, drinkSize);
				drink.setPrice(amount);
				
				lineItem = new SaleLineItem(name, quantity, amount);
				saleLineItems.add(lineItem);
				
			}else if(itemType.contains("addon")){
				addon = new AddOn(name);
				
				for(String parameter:subs){
					String[] values = parameter.split("=");
					if(values[0].equals("quantity")){
						quantity = Integer.parseInt(values[1]);
						addon.setQuantity(quantity);
					}
				}
				amount = addon.calculateAddOnPrice(quantity, name);
				addon.setPrice(amount);
				
				lineItem = new SaleLineItem(name, quantity, amount);
				saleLineItems.add(lineItem);
					
			}else if(itemType.contains("delete")){
				System.out.println("Here into delete");
				Iterator<SaleLineItem> itr1= saleLineItems.iterator();
				SaleLineItem itemName=null;
				for(String parameter:subs){
					String[] values = parameter.split("=");
					if(values[0].equals("name")){
						while(itr1.hasNext()){
							itemName = itr1.next();
							if(itemName.getName().equals(values[1])){
								break;
							}
							
						}
					}
					saleLineItems.remove(itemName);
				}
			}
			
			
			 sale =  new Sale(saleLineItems);
			 sale.calculateTotal();
		}else if (itemType.equals("discount")) {
			
			System.out.println("itemType is ---"+itemType);
			String[] subs = query.split("&");
			name = query.substring(query.indexOf("name=")+5, query.indexOf("&number"));
			System.out.println("Name is finally ;;;;;"+name);
			if(name.contains("coupon")){
				System.out.println("into coupon");
				for(String parameter:subs){
					System.out.println("Into coupon");
					String[] values = parameter.split("=");
					if(values[0].equals("number")){
						System.out.println("Coupon value is "+values[1]);
						sale.setCoupon(values[1]);
					}
				}
			}else if(name.contains("redeempoints")){
				System.out.println("into redeem points");
				for(String parameter:subs){
					
					String[] values = parameter.split("=");
					if(values[0].equals("number")){
						System.out.println("poitns number "+values[1]);
						if(Integer.parseInt(values[1]) > 0){
							sale.setFrequentPoints(Integer.parseInt(values[1]));
						}

					}
				}
			}
			
			sale.calculateTotalAfterDiscount();
			
		}
		
		return itemType;
		
	}


	//Turns the ArrayList<Pizza> into an XML representation
	private String getXml(String itemType) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		Iterator<SaleLineItem> itr = saleLineItems.iterator();
		buffer.append("<Sale>");
		buffer.append("<Items>");
		while(itr.hasNext()){
			SaleLineItem lineItemlocal = itr.next();
			buffer.append("<Item>");
			buffer.append("<name>");
			buffer.append(lineItemlocal.getName());
			buffer.append("</name>");
			buffer.append("<quantity>");
			buffer.append(lineItemlocal.getQuantity());
			buffer.append("</quantity>");
			buffer.append("<price>");
			buffer.append(lineItemlocal.getPrice());
			buffer.append("</price>");
			buffer.append("</Item>");
			
		}
		buffer.append("</Items>");
		
		buffer.append("<Payment>");
		if(!itemType.equals("discount")){
			buffer.append("<amountBeforeTax>");
			buffer.append(sale.getTotalAmountBeforeTax());
			buffer.append("</amountBeforeTax>");
			buffer.append("<tax>");
			buffer.append(sale.getTax());
			buffer.append("</tax>");
			buffer.append("<totalAmount>");
			buffer.append(sale.getTotalAmount());
			buffer.append("</totalAmount>");
		}else if(itemType.equals("discount")){
			buffer.append("<amountBeforeTax>");
			buffer.append(sale.getTotalAmountBeforeTax());
			buffer.append("</amountBeforeTax>");
			buffer.append("<couponAmount>");
			buffer.append(sale.getCouponAmount());
			buffer.append("</couponAmount>");
			buffer.append("<frequentPointsAmount>");
			buffer.append(sale.getFrequentPointsAmount());
			buffer.append("</frequentPointsAmount>");
			buffer.append("<totalAmountBeforeTaxAppliedDiscount>");
			buffer.append(sale.getTotalAmountDiscountBeforeTax());
			buffer.append("</totalAmountBeforeTaxAppliedDiscount>");
			buffer.append("<taxafterAppliedDiscount>");
			buffer.append(sale.getTaxDiscount());
			buffer.append("</taxafterAppliedDiscount>");
			buffer.append("<totalAmountAfterDiscount>");
			buffer.append(sale.getTotalAmountAfterDiscount());
			buffer.append("</totalAmountAfterDiscount>");
		}
		
		buffer.append("</Payment>");
		buffer.append("</Sale>");
		return buffer.toString();
	}

	
}
