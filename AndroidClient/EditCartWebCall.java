package com.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.AsyncTask;
import android.util.Log;

public class EditCartWebCall extends AsyncTask{

	private final static String TAG1 = "editurl";
	private final static String TAG2 = "editItem";
	private static final String PIZZATAG = "Pizza";
	private static final String PIZZATOPPINGTAG = "PizzaTopping"; 
	private static final String TOPPINGTAG = "Topping";
	private static final String BASETAG = "Base";
	static WebPizza objwebpizza;
	String itemid;
	public EditCartWebCall(String itemid){
		this.itemid = itemid;
	}
	@Override
	protected Object doInBackground(Object... params) {
		String result = null;		
		Log.v(TAG2, itemid);
		String url = "http://10.0.2.2:8000/payment?item=edit&name="+itemid;
		Log.v(TAG1, url);
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
		return objwebpizza;
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
		
		private static String xmlparser(String xmldata) {
			//Log.v(TAG1, xmldata);
			List<String> pizzatopping = new ArrayList<String>();
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
			             //System.out.println("Start tag "+xpp.getName());
						String tagname = xpp.getName();
			             //Log.v(ParseTAG, tagname);
			             if(tagname.equals("Item")){
			            	 objwebpizza = new WebPizza(null, null, null, null, null, pizzatopping);
			            	 xpp.nextTag();
			            	 String subtagid = xpp.getName();
			            	 if(subtagid.equals("id")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebpizza.setPizzaID(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagname = xpp.getName();
			            	 if(subtagname.equals("name")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebpizza.setPizzaItem(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagtopping = xpp.getName();
			            	 if(subtagtopping.equals("topping")){
			            		 while((xpp.nextTag() != XmlPullParser.END_TAG) && (!xpp.getName().equals("topping"))){
			            			 System.out.println("Topping tag");
			            			 String text = xpp.nextText();
			            			 pizzatopping.add(text);
				            		 System.out.println(text);
			            		 }
			            		
			            		 //objwebsale.setSaleQuan(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagbase = xpp.getName();
			            	 if(subtagbase.equals("base")){
			            		 String text = xpp.nextText();
			            		 System.out.println("base: "+text);
			            		 objwebpizza.setPizzaBase(text);		            		 
			            	 }
			            	 xpp.nextTag();
			            	 String subtagquan = xpp.getName();
			            	 if(subtagquan.equals("quantity")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebpizza.setPizzaQuan(text);
			            	 }
			            	 xpp.nextTag();
			            	 String subtagprice = xpp.getName();
			            	 if(subtagprice.equals("price")){
			            		 String text = xpp.nextText();
			            		 System.out.println(text);
			            		 objwebpizza.setpizzaprice(text);		            		 
			            	 }
			            	 WebPizza.saleset.add(objwebpizza);
			             } 		             
			        } 
					//System.out.println("");
					
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
