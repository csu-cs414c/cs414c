package com.example.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.google.common.collect.Multimap;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WebServiceToppingActivity extends Activity {
	private static final String wstaTOPPINGTAG = "alActivity"; 
	//private static final String wstaSELECTTOPPING = "alActivity1";
	private static final String wstaSELECTBASE = "selectbase";
	private static final String wstaSELECTTOPPING = "selTopping";
	private static final String wstaNONSELECTTOPPING = "nonselTopping";
	private static final String wstaFINALAL = "addtocarttop";
	private static final String wstaAddtoCartbase = "addtocartbase";
	private static final String wstaAddtoCartquan = "addtocartquan";
	private static final String wstaAddtoCartALSize = "addtocarttopALsize";
	//private static final String TAG2 = "buttonActivity"; 
	Multimap<String, String> toppingsforapizza;
	List<String> editpizzatopping = new ArrayList<String>();
	String editpizzaname;
	String editpizzaid;
	String editpizzabase;
	String editpizzaquan;
	String editpizzaprice;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_service_topping);
		Intent intent = getIntent();
		String type = intent.getStringExtra("type");
		if(type.equals("new")){
			System.out.println("type: "+type);
			String message = intent.getStringExtra("buttonvalue");
			WebMenu.pizzaname = message;
			toppingsforapizza = WebMenu.toppingsforapizza;
			Set<String> temptoppingset = (Set)toppingsforapizza.get(message);
			WebMenu.pizzatoppingsel.addAll(temptoppingset);
				//System.out.println("temptoppingset size: "+temptoppingset.size());
			Set<String> toppingset = WebMenu.pizzatoppings;
			//
			LinearLayout ll = (LinearLayout)findViewById(R.id.linearlayout1);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			LayoutParams lparams = new LayoutParams(
					   LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			GridLayout gl1 = new GridLayout(this);
			gl1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			gl1.setOrientation(0);
			gl1.setColumnCount(3);
			gl1.setRowCount(2);
			//
			
			//GridLayout  lm = (GridLayout )findViewById(R.id.linearlayout1);
			//LinearLayout ltext1 = new LinearLayout(this);
			TextView texttopping = new TextView(this);
			texttopping.setText("Toppings");
			texttopping.setLayoutParams(lparams);
	        //ltext1.addView(texttopping);
	        ll.addView(texttopping, lp);
	        //LinearLayout ll = new LinearLayout(this);
	        //ll.setOrientation(LinearLayout.HORIZONTAL);
	        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			for(String topping: toppingset){
				
				final String selecttext = topping;
				final CheckBox toppingcheckbox = new CheckBox(this);
				if(temptoppingset.contains(topping)){
					toppingcheckbox.setChecked(true);
				}
				
				toppingcheckbox.setText(topping);
	            
	            //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);	
	            toppingcheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener(){	
	            	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
	            		if(isChecked){
	            			Log.v(wstaSELECTTOPPING, selecttext);
	            			WebMenu.pizzatoppingsel.add(selecttext);
	            		}
	            		else {
	            			Log.v(wstaNONSELECTTOPPING, selecttext);
	            			WebMenu.pizzatoppingsel.remove(selecttext);
	            		}
	            			
	            		
	            		//Intent intent = new Intent(WebServiceActivity.this, WebServiceToppingActivity.class);
	            		//startActivity(intent);
	            	}
	            });
	            gl1.addView(toppingcheckbox);
	            
				
			}
			ll.addView(gl1);
			
			//Adding Base

			TextView textbase = new TextView(this);
			
			textbase.setText("Pizza Base");
			textbase.setLayoutParams(lparams);
	        ll.addView(textbase, lp);
	        Set<String> baseset = WebMenu.pizzabase;
	        
	        GridLayout gl2 = new GridLayout(this);
			gl2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			gl2.setOrientation(0);
			gl2.setColumnCount(3);
			gl2.setRowCount(1);
			RadioGroup rg = new RadioGroup(this);
			rg.setOrientation(0);
	        for(String basename: baseset){
	        	final String selecttext = basename;
				RadioButton rb = new RadioButton(this);
				rb.setText(basename);
				rb.setOnClickListener(new View.OnClickListener(){	
	            	public void onClick(View view){
	            		Log.v(wstaSELECTBASE, selecttext);  
	            		WebMenu.pizzabasename = selecttext;
	            		//Intent intent = new Intent(WebServiceActivity.this, WebServiceToppingActivity.class);
	            		//startActivity(intent);
	            	}
	            });
	            rg.addView(rb);
	        }
	        gl2.addView(rg);
	        ll.addView(gl2);
	        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			//LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView textquan = new TextView(this);
			textquan.setText("Quantity");
			textquan.setLayoutParams(lparams);
			
	        //ltext1.addView(texttopping);
			//ll.addView(gl);
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
					   WebMenu.pizzaquantity = s.toString();
				   }
				  });
			ll.addView(textquantity);
			//Adding Add to cart button
			Button addtocartbutton = new Button(this);
			addtocartbutton.setText("Add to cart");
			addtocartbutton.setOnClickListener(new View.OnClickListener(){	
	        	public void onClick(View view){  
	        		ArrayList<String> selpizzatopping = new ArrayList<String>(WebMenu.pizzatoppingsel);
	        		Intent intent = new Intent(WebServiceToppingActivity.this, SaleWebServiceActivity.class);
	        		for(String temp : WebMenu.pizzatoppingsel){
	        			Log.v(wstaFINALAL, temp);	
	        		}
	        		Log.v(wstaAddtoCartbase, WebMenu.pizzabasename);
	        		Log.v(wstaAddtoCartquan, WebMenu.pizzaquantity);
	        		
	        		//Loading intent
	        		intent.putStringArrayListExtra("selpizzatopping", (ArrayList<String>)selpizzatopping);
	        		intent.putExtra("selpizzabase", WebMenu.pizzabasename);
	        		intent.putExtra("selpizzaquan", WebMenu.pizzaquantity);
	        		intent.putExtra("selpizzaname", WebMenu.pizzaname);
	        		intent.putExtra("type", "one");
	        		
	        		Log.v(wstaAddtoCartALSize, selpizzatopping.size()+"");
	        		startActivity(intent);
	        	}
	        });
	        ll.addView(addtocartbutton, lp);
		} else if(type.equals("edit")){
			System.out.println("type: "+type);
			toppingsforapizza = WebMenu.toppingsforapizza;
			Set<String> temptoppingset = new HashSet<String>(intent.getStringArrayListExtra("edittoppinglist"));
			editpizzaname = intent.getStringExtra("editpizzaname");
			editpizzabase = intent.getStringExtra("editpizzabase");
			editpizzaquan = intent.getStringExtra("editpizzaquan");
			System.out.println("editpizzabase: "+editpizzabase);
			System.out.println("editpizzaname: "+editpizzaname);
			WebMenu.pizzatoppingsel.addAll(temptoppingset);
				//System.out.println("temptoppingset size: "+temptoppingset.size());
			Set<String> toppingset = WebMenu.pizzatoppings;
			//
			LinearLayout ll = (LinearLayout)findViewById(R.id.linearlayout1);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			LayoutParams lparams = new LayoutParams(
					   LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			GridLayout gl1 = new GridLayout(this);
			gl1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			gl1.setOrientation(0);
			gl1.setColumnCount(3);
			gl1.setRowCount(2);
			//
			
			//GridLayout  lm = (GridLayout )findViewById(R.id.linearlayout1);
			//LinearLayout ltext1 = new LinearLayout(this);
			TextView texttopping = new TextView(this);
			texttopping.setText("Toppings");
			texttopping.setLayoutParams(lparams);
	        //ltext1.addView(texttopping);
	        ll.addView(texttopping, lp);
	        //LinearLayout ll = new LinearLayout(this);
	        //ll.setOrientation(LinearLayout.HORIZONTAL);
	        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			for(String topping: toppingset){
				
				final String selecttext = topping;
				final CheckBox toppingcheckbox = new CheckBox(this);
				if(temptoppingset.contains(topping)){
					toppingcheckbox.setChecked(true);
				}
				
				toppingcheckbox.setText(topping);
	            
	            //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);	
	            toppingcheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener(){	
	            	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
	            		if(isChecked){
	            			Log.v(wstaSELECTTOPPING, selecttext);
	            			WebMenu.pizzatoppingsel.add(selecttext);
	            		}
	            		else {
	            			Log.v(wstaNONSELECTTOPPING, selecttext);
	            			WebMenu.pizzatoppingsel.remove(selecttext);
	            		}
	            			
	            		
	            		//Intent intent = new Intent(WebServiceActivity.this, WebServiceToppingActivity.class);
	            		//startActivity(intent);
	            	}
	            });
	            gl1.addView(toppingcheckbox);
	            
				
			}
			ll.addView(gl1);
			
			//Adding Base

			TextView textbase = new TextView(this);
			
			textbase.setText("Pizza Base");
			textbase.setLayoutParams(lparams);
	        ll.addView(textbase, lp);
	        Set<String> baseset = WebMenu.pizzabase;
	        
	        GridLayout gl2 = new GridLayout(this);
			gl2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			gl2.setOrientation(0);
			gl2.setColumnCount(3);
			gl2.setRowCount(1);
			final RadioGroup rg = new RadioGroup(this);
			rg.setOrientation(0);
	        for(String basename: baseset){
	        	final String selecttext = basename;
				RadioButton rb = new RadioButton(this);
				rb.setText(basename);
				System.out.println("rb: "+basename);
				System.out.println("rb editpizzabase:  "+editpizzabase);
				rg.addView(rb);
				if(basename.equals(editpizzabase)){
					System.out.println("Base equals");
					rg.check(rb.getId());
				}             
	        }
	        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					//group.clearCheck();
				
					int id = group.getCheckedRadioButtonId();
					RadioButton selectrb = (RadioButton) findViewById(id);
					System.out.println(selectrb.getText().toString());
					editpizzabase = selectrb.getText().toString();
					
					
				}
			});
	        gl2.addView(rg);
	        ll.addView(gl2);
	        //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			//LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			TextView textquan = new TextView(this);
			textquan.setText("Quantity");
			textquan.setLayoutParams(lparams);
			
	        //ltext1.addView(texttopping);
			//ll.addView(gl);
			ll.addView(textquan, lp);
			EditText textquantity = new EditText(this);
			textquantity.setLayoutParams(lparams);
			textquantity.setText(editpizzaquan);
			textquantity.addTextChangedListener(new TextWatcher() {
				 
				   public void afterTextChanged(Editable s) {
				   }
				 
				   public void beforeTextChanged(CharSequence s, int start, 
				     int count, int after) {
				   }
				 
				   public void onTextChanged(CharSequence s, int start, 
				     int before, int count) {
					   editpizzaquan = s.toString();
				   }
				  });
			ll.addView(textquantity);
			//Adding Add to cart button
			Button addtocartbutton = new Button(this);
			addtocartbutton.setText("Add to cart");
			addtocartbutton.setOnClickListener(new View.OnClickListener(){	
	        	public void onClick(View view){  
	        		ArrayList<String> selpizzatopping = new ArrayList<String>(WebMenu.pizzatoppingsel);
	        		Intent intent = new Intent(WebServiceToppingActivity.this, SaleWebServiceActivity.class);
	        		for(String temp : WebMenu.pizzatoppingsel){
	        			Log.v(wstaFINALAL, temp);	
	        		}
	        		Log.v(wstaAddtoCartbase, editpizzabase);
	        		Log.v(wstaAddtoCartquan, editpizzaquan);
	        		
	        		//Loading intent
	        		intent.putStringArrayListExtra("selpizzatopping", (ArrayList<String>)selpizzatopping);
	        		intent.putExtra("selpizzabase", editpizzabase);
	        		intent.putExtra("selpizzaquan", editpizzaquan);
	        		intent.putExtra("selpizzaname", editpizzaname);
	        		intent.putExtra("type", "one");
	        		
	        		Log.v(wstaAddtoCartALSize, selpizzatopping.size()+"");
	        		startActivity(intent);
	        	}
	        });
	        ll.addView(addtocartbutton, lp);
		}
				
		
		//lm.addView(ll, lp);
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

