package edu.colostate.cs.cs414c.WebCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import edu.colostate.cs.cs414c.UI.CustomerUI;
import edu.colostate.cs.cs414c.UI.StoresUI;

import android.os.AsyncTask;

public class CarryOutWebCall extends AsyncTask{

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		
		String result = null;
		Set<StoresUI> stores = null;
		String url = "http://10.0.2.2:8000/user?type=store&name=all";
		System.out.println("URL is "+url);
		HttpClient httpclient = new DefaultHttpClient();
		// call over get. Httpget. pass in the url
		HttpGet httpget = new HttpGet(url);
		
		HttpResponse response;
		
		try{
			// set the resonse to actual call. call using the client that url from above.
			response = httpclient.execute(httpget);
			// value we care about. get the value the request returns
			HttpEntity entity = response.getEntity();
			// ensure we got something
			
			if(entity !=null){
				InputStream instream = entity.getContent();
				
				result = convertToString(instream);
				stores = xmlparser(result);
				// print to logcat
				System.out.println(result);
				instream.close();
			}
		}catch(Exception e){
			System.out.println("Log cat "+ e.toString());
		}
		return result;
	}
	
	public String convertToString(InputStream is){
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		// StringBuffer creates the string efficiently
		StringBuffer buff = new StringBuffer();
		
		String line = null;
		
		try{
			// Iterate over all the strings and build the value
			
			line = reader.readLine();
			//System.out.println("Line is : "+line);
			while(line!=null){
				buff.append(line + "\n");
				line = reader.readLine();
			}
			
			is.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return buff.toString();
		
	}
	
	private Set<StoresUI> xmlparser(String xmldata) {
		 StringBuffer buff = new StringBuffer();
		 StoresUI store = null;
		 Set<StoresUI> stores = new HashSet<StoresUI>();
		 try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				xpp.setInput(new StringReader(xmldata));
				int eventType = xpp.getEventType();
				
				int i=0;
				while(eventType != XmlPullParser.END_DOCUMENT){
					
			        if(eventType == XmlPullParser.START_TAG){
			        	String tagName = xpp.getName();
			        	if(tagName.equals("store")){
			        		store = new StoresUI();
			        		StoresUI.stores.add(store);
			        		
			        	}
			        	if(tagName.equals("storename")){
			        		store.setStoreName(xpp.nextText());
			        		System.out.println("Store" +store.getStoreName());
			        	}
			        	if(tagName.equals("storeid")){
			        		store.setStoreId(xpp.nextText());
			        		System.out.println("Store" +store.getStoreId());
			        	}
			        	if(tagName.equals("address1")){
			        		store.setAddress1(xpp.nextText());
			        		System.out.println("Store" +store.getAddress1());
			        	}
			        	if(tagName.equals("address2")){
			        		store.setAddress2(xpp.nextText());
			        		System.out.println("Store" +store.getAddress2());
			        	}
			        	if(tagName.equals("city")){
			        		store.setCity(xpp.nextText());
			        		System.out.println("Store" +store.getCity());
			        	}
			        	if(tagName.equals("state")){
			        		store.setState(xpp.nextText());
			        		System.out.println("Store" +store.getState());
			        	}
			        	if(tagName.equals("zip")){
			        		store.setZip(xpp.nextText());
			        		System.out.println("Store" +store.getZip());
			        	}
			        	if(tagName.equals("phone")){
			        		store.setPhone(xpp.nextText());
			        		System.out.println("Store" +store.getPhone());
			        	}
			        	if(tagName.equals("montosattime")){
			        		store.setMontosatTiming(xpp.nextText());
			        		System.out.println("Store" +store.getMontosatTiming());
			        	}
			        	if(tagName.equals("suntime")){
			        		store.setSunTiming(xpp.nextText());
			        		System.out.println("Store" +store.getSunTiming());
			        	}
			        
						
					}
					
			        eventType = xpp.next();
					i++;
			          
				}
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 return stores;
	}
	
	

}
