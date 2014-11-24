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

import android.os.AsyncTask;

public class UerAddWebCall extends AsyncTask{

	@Override
	protected Object doInBackground(Object... params) {
		String result = null;
		String userName = params[0].toString();
		String password = params[1].toString();
		String fullname = params[2].toString();
		String address1 =params[3].toString();
		String address2 = params[4].toString();
		String city = params[5].toString();
		String state = params[6].toString();
		String zip = params[7].toString();
		String phone = params[8].toString();
		String email = params[9].toString();
		
		String url = "http://localhost:8000/useradd?type=useradd&username="+userName+"&password="+password+"&fullname="+fullname+"&address1="+address1+"&address2="+address2+"&city="+city+"&state="+state+"&zip="+zip+"&phone="+phone+"&email="+email;
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
				xmlparser(result);
				// print to logcat
				//System.out.println(result);
				instream.close();
			}
		}catch(Exception e){
			System.out.println("Log cat "+ e.toString());
		}
		return result;
	}
	
	private String convertToString(InputStream is){
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		// StringBuffer creates the string efficiently
		StringBuffer buff = new StringBuffer();
		
		String line = null;
		
		try{
			// Iterate over all the strings and build the value
			
			line = reader.readLine();
			System.out.println("Line is : "+line);
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
	
	private String xmlparser(String xmldata) {
        Set<String> al = new HashSet<String>();
        //Log.v(TAG, xmldata);
        StringBuffer buff = new StringBuffer();
	
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
		        	
		        	if(tagName.equals("message")){
		        		CustomerUI.warning=xpp.nextText();
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
		return buff.toString();
	}

}
