package com.example.client;

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

import android.os.AsyncTask;
import android.util.Log;

public class DrinkWebCall extends AsyncTask {
	private Set<String> al = new HashSet<String>();
	private static final String ParseTAG = "Drink";
	private static final String DRINKTAG = "drinkname"; 
	
	@Override
	protected Object doInBackground(Object... params) {
		String result = null;
		String url = "http://10.0.2.2:8000/drinkmenu";
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				InputStream instream = entity.getContent();
				xmlparser(convertToString(instream));
				//System.out.println(result);
				instream.close();
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		
		return al;
	}
	
	private void xmlparser(String xmldata) {
		//Log.v(TAG, xmldata);
		//StringBuffer buff = new StringBuffer();
		
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
		             Log.v(ParseTAG, tagname);
		             if(tagname.equals("drinkname")){		            	 
		            	String text = xpp.nextText();
		            	Log.v(DRINKTAG, text);
		            	al.add(text);		            		            	
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
		
		
}
