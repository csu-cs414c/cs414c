package com.example.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddonWebServiceActivity extends Activity {
	private static final String TAG = "AddonName";
	private static final String TAG3 = "AddonQuan"; 
	private static final String TAG1 = "alActivity1";
	private static final String TAG2 = "DrinkActivity"; 
	Set<String> al;
	Set<String> values = new HashSet<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_service_addon);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		AsyncTask result = new AddonWebCall().execute();
		try {
			al = (Set<String>)result.get();
			//final String selectaddon = null;
			//al = WebMenu.pizza;
			Log.v(TAG1, al.size()+"");
			Iterator<String> itr = al.iterator();
			LinearLayout ll = (LinearLayout)findViewById(R.id.linearlayout1);
			//ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			GridLayout gl = new GridLayout(this);
			gl.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			gl.setOrientation(0);
			gl.setColumnCount(2);
			gl.setRowCount(7);
			RadioGroup rg = new RadioGroup(this);
			rg.setOrientation(1);
			while(itr.hasNext()){
				final String addonname = itr.next();
				//LinearLayout ll1 = new LinearLayout(this);
				
				//ll1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				//ll1.setOrientation(LinearLayout.HORIZONTAL);
				RadioButton rb = new RadioButton(this);
				rb.setText(addonname);
				rb.setOnClickListener(new View.OnClickListener(){	
	            	public void onClick(View view){
	            		Log.v(TAG2, addonname);   
	            		values.add(addonname);
	            		WebMenu.addonname = addonname;
	            		//Intent intent = new Intent(WebServiceActivity.this, WebServiceToppingActivity.class);
	            		//startActivity(intent);
	            	}
	            });         
				
	            rg.addView(rb);
	            //gl.addView(rg);
	            //gl.addView(textquantity);
	            //ll.addView(ll1);
			}
			gl.addView(rg);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView textquan = new TextView(this);
			textquan.setText("Quantity");
			textquan.setLayoutParams(lparams);
			
	        //ltext1.addView(texttopping);
			ll.addView(gl);
			ll.addView(textquan, lp);
			EditText textquantity = new EditText(this);
			textquantity.setLayoutParams(lparams);
			textquantity.addTextChangedListener(new TextWatcher() {
				 
				   public void afterTextChanged(Editable s) {
				   }
				 
				   public void beforeTextChanged(CharSequence s, int start, 
				     int count, int after) {
				   }
				 
				   public void onTextChanged(CharSequence s, int start, 
				     int before, int count) {
					   WebMenu.addonquantity = s.toString();
				   }
				  });
			ll.addView(textquantity);
			//Add to cart
			Button addtocartbutton = new Button(this);
			addtocartbutton.setText("Add to cart");
			addtocartbutton.setOnClickListener(new View.OnClickListener(){	
	        	public void onClick(View view){  
	        		Log.v(TAG, WebMenu.addonname);
	        		Log.v(TAG3, WebMenu.addonquantity);
	        		
	        		//Intent intent = new Intent(PizzaWebServiceActivity.this, WebServiceToppingActivity.class);
	        		//intent.putExtra("buttonvalue", buttontext);
	        		//startActivity(intent);
	        	}
	        });
	        ll.addView(addtocartbutton, lp);
			//lm.addView(ll, lp);
			
			
			
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

