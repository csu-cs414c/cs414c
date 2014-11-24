package edu.colostate.cs.cs414c.WebCall;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class PizzaWebCall extends AsyncTask{

	@Override
	protected Object doInBackground(Object... params) {
		String result = null;
		
		String url ="http://10.0.2.2:8000/pizzas";
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		
		try{
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return null;
	}

}
