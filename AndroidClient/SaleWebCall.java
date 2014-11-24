package com.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import android.os.AsyncTask;
import android.util.Log;

public class SaleWebCall extends AsyncTask  {
	private static final String TAG1 = "SalelineItemxml"; 
	private Set<String> al = new HashSet<String>();
	ArrayList<String> selpizzatopping = new ArrayList<String>();
	String selbasename;
	String selpizzaquan;
	String selpizzaname;
	private static final String urlform = "url";
	
	
	public SaleWebCall(ArrayList<String> selpizzatopping, String selbasename, String selpizzaquan, String selpizzaname){
		this.selpizzatopping = selpizzatopping;
		this.selbasename = selbasename;
		this.selpizzaquan = selpizzaquan;
		this.selpizzaname = selpizzaname;
		
	}
	@Override
	protected Object doInBackground(Object... params) {
		String result = null;
		String url = "http://10.0.2.2:8000/payment?item=pizza";
		WebSale.saleset.clear();
		
		//Forming dynamic url to hit web service
		url = urlFormation(url);
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				InputStream instream = entity.getContent();
				result = xmlparser(convertToString(instream));
				System.out.println(result);
				instream.close();
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		
		return WebSale.saleset;
	}
	
	private String urlFormation(String url){
		if(containsWhiteSpace(selbasename))
			url = url + "&name=" + selpizzaname.substring(0, selpizzaname.indexOf(" ")) + "%20"+selpizzaname.substring(selpizzaname.indexOf(" ")+1, selpizzaname.length()) +"&quantity="+ selpizzaquan +  "&size=8" +"&base=" + selbasename.substring(0, selbasename.indexOf(" ")) + "%20"+selbasename.substring(selbasename.indexOf(" ")+1, selbasename.length()) + "&toppings=";
		else
			url = url + "&name=" + selpizzaname.substring(0, selpizzaname.indexOf(" ")) + "%20"+selpizzaname.substring(selpizzaname.indexOf(" ")+1, selpizzaname.length()) +"&quantity="+ selpizzaquan +  "&size=8" +"&base=" + selbasename+ "&toppings=";
		String seltop = "";
		int i=1;
		for(String topping : selpizzatopping){
			if(i == 1)
				seltop = seltop + topping;
			else
				seltop = seltop + "-" + topping;
			i++;
		}
		
		url = url + seltop;
		Log.v(urlform, url);
		return url;		
	}
	
	public static boolean containsWhiteSpace(final String testCode){
	    if(testCode != null){
	        for(int i = 0; i < testCode.length(); i++){
	            if(Character.isWhitespace(testCode.charAt(i))){
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	//converts an input stream to a string
		private String convertToString(InputStream is) {
			//buffered reader reads the input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			//StringBuffer creates the string efficiently
			StringBuffer buff = new StringBuffer();

			String line = null;
			try {
				//iterate over all the strings and build the value
				//line = reader.readLine();
				while ((line = reader.readLine()) != null) 
				{
					//Log.v(TAG1, line);
					//buff.append("data: ");
					buff.append(line);
					buff.append("\n");
				}
				is.close();
			} 
			catch (Exception e) 
			{
				//you can change your code to handle an exception how you want
				System.out.println(e.toString());
			} 
			return buff.toString();
		}
	
	private String xmlparserold(String xmldata) {
		Log.v(TAG1, xmldata);
		StringBuffer buff = new StringBuffer();
		
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(new StringReader(xmldata));
			int eventType = xpp.getEventType();
			String flag = null;
			while(eventType != XmlPullParser.END_DOCUMENT){
				if(eventType == XmlPullParser.START_DOCUMENT){
					System.out.println("Start Document");
				} else if(eventType == XmlPullParser.START_TAG) {
		             //System.out.println("Start tag "+xpp.getName());
					String tagname = xpp.getName();
		             //Log.v(ParseTAG, tagname);
		             if(tagname.equals("Item")){
		       
		            	 if(tagname.equals("name")){
		            		 
		            	 }
		            	String text = xpp.nextText();		            	
		            	// 	WebMenu.pizza.add(text);
		            		            	
		             } else if(tagname.equals("pizzatopping")){
		            	 String text = xpp.nextText();
		            	// Log.v(PIZZATAG, flag);	
		            	// Log.v(PIZZATOPPINGTAG, text);
		            	 WebMenu.toppingsforapizza.put(flag, text);
		            	 
		             }
		             
		             if(tagname.equals("basename")){
		            	 String text = xpp.nextText();
		            	 WebMenu.pizzabase.add(text);
		            	 //Log.v(BASETAG, text);
		             } else if(tagname.equals("toppingname")){
		            	 String text = xpp.nextText();
		            	 WebMenu.pizzatoppings.add(text);
		            	 //Log.v(TOPPINGTAG, text);
		             }
		             
		        } 
				
		          eventType = xpp.next();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buff.toString();
	}
	
	private static String xmlparser(String xmldata) {
		Log.v(TAG1, xmldata);
		StringBuffer buff = new StringBuffer();	
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(new StringReader(xmldata));
			int eventType = xpp.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				if(eventType == XmlPullParser.START_DOCUMENT){
					System.out.println("Start Document");
				} else if(eventType == XmlPullParser.START_TAG) {
					//xpp.nextTag();
		             //System.out.println("Start tag "+xpp.getName());
					String tagname = xpp.getName();
					System.out.println("Sale tag name: "+tagname);	
					xpp.nextTag();
					while((xpp.nextTag() != XmlPullParser.END_TAG) && (!xpp.getName().equals("Items"))){
						System.out.println("Entered while");
						//xpp.nextTag();	
						System.out.println("item: "+xpp.getName());
						if(xpp.getName().equals("Item")){
							
							WebSale objwebsale = new WebSale(null, null, null, false);
							System.out.println("Entered item tag");						
			            	 xpp.nextTag();
			            	 String subtagid = xpp.getName();
			            	 System.out.println("subtagid: "+subtagid);
			            	 if(subtagid.equals("id")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebsale.setSaleID(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagname = xpp.getName();
			            	 if(subtagname.equals("name")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebsale.setSaleItem(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagquan = xpp.getName();
			            	 if(subtagquan.equals("quantity")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebsale.setSaleQuan(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagprice = xpp.getName();
			            	 if(subtagprice.equals("price")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebsale.setSalePrice(text);		            		 
			            	 }	
		            	 	WebSale.saleset.add(objwebsale);
		            	 	
						}
						xpp.next();
		            	 
		             
					}
						xpp.nextTag();	
						String paymenttag = xpp.getName();
						System.out.println("Payment tag: "+paymenttag);
						if(paymenttag.equals("Payment")){
						 xpp.nextTag();
		            	 String subtagsubtotal = xpp.getName();
		            	 if(subtagsubtotal.equals("amountBeforeTax")){
		            		 String text = xpp.nextText();
		            		 System.out.println(text);
		            		 WebPayment.paymentsubtotal = text;		            	 }
		            	 xpp.nextTag();
		            	 String subtagtax = xpp.getName();
		            	 if(subtagtax.equals("tax")){
		            		 String text = xpp.nextText();
		            		 System.out.println(text);
		            		 WebPayment.paymenttax = text;
		            	 }
		            	 xpp.nextTag();
		            	 String subtagtotal = xpp.getName();
		            	 if(subtagtotal.equals("totalAmount")){
		            		 String text = xpp.nextText();
		            		 System.out.println(text);
		            		 WebPayment.paymenttotal = text;
		            	 }	
						}
		            	 
		             }
				 eventType = xpp.next();
		             
		        }        
			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buff.toString();
	}
	
}
