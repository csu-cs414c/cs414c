package com.example.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PizzaWebServiceActivity extends Activity {
	private static final String TAG = "alActivity"; 
	private static final String TAG1 = "alActivity1";
	private static final String TAG2 = "buttonActivity"; 
	Set<String> al;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_service);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		AsyncTask result = new PizzaWebCall().execute();
		try {
			al = (Set<String>)result.get();
			al = WebMenu.pizza;
			Log.v(TAG1, al.size()+"");
			Iterator<String> itr = al.iterator();
			while(itr.hasNext()){
				Button pizzabutton = new Button(this);
				final String buttontext = itr.next();
				Log.v(TAG, buttontext);
				pizzabutton.setText(buttontext);
	            LinearLayout ll = (LinearLayout)findViewById(R.id.linearlayout1);
	            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);	
	            pizzabutton.setOnClickListener(new View.OnClickListener(){	
	            	public void onClick(View view){
	            		Log.v(TAG2, buttontext);   
	            		Intent intent = new Intent(PizzaWebServiceActivity.this, WebServiceToppingActivity.class);
	            		intent.putExtra("buttonvalue", buttontext);
	            		intent.putExtra("type", "new");
	            		startActivity(intent);
	            	}
	            });
	            ll.addView(pizzabutton, lp);
			}
			
			
			
			
			//buttonView.setText(xml);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
