package edu.colostate.cs.cs414c.Activity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.example.testing.R;
import com.example.testing.R.id;
import com.example.testing.R.layout;
import com.example.testing.R.menu;

import edu.colostate.cs.cs414c.UI.StoresUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StoresActivity extends Activity {

	
	Set<StoresUI> stores = new HashSet<StoresUI>();
	StoresUI store = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stores);
		stores.addAll(StoresUI.stores);
		
		getStores();
		
		Button button = (Button)findViewById(R.id.button21);
		Button buttonsecond = (Button) findViewById(R.id.button22);
		
		button.setOnClickListener(
				new View.OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						System.out.println("Buton 1 "+ stores.size());
						Iterator<StoresUI> itr = stores.iterator();
						while(itr.hasNext()){
							store = itr.next();
							
							if(store.getButtonName().equals("button21")){
								System.out.println("into here");
								StoresUI.selectedStore = store;
								
								// show the pizza.
							}
						}
					}
					
				});
		
		buttonsecond.setOnClickListener(
				new View.OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						System.out.println("Button 2");
						Iterator<StoresUI> itr = stores.iterator();
						while(itr.hasNext()){
							store = itr.next();
							
							if(store.getButtonName().equals("button22")){
								StoresUI.selectedStore = store;
								
								// show the pizza.
							}
						}
					}
					
				});
		
		
		
		
	}
	
	public void getStores(){
		
		RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
		
		TextView t1 =null;
		
		
		System.out.println("lenght is "+stores.size());
		Iterator<StoresUI> itr = stores.iterator();
		while(itr.hasNext()){
			store = itr.next();
			System.out.println("store name is :---- "+ store.getStoreName()+ "store id "+store.getStoreId());
			switch (Integer.parseInt(store.getStoreId())){
				case 1: t1= (TextView)findViewById(R.id.textview11);
						store.setButtonName("button21");
						break;
				case 2: t1= (TextView)findViewById(R.id.textview13);
						store.setButtonName("button22");
						break;
				
			}
			
			t1.setText(store.getStoreName()+"\n"+store.getAddress1()+"\n"+store.getCity()+"\n"+store.getState()+store.getZip()+"\n"+store.getPhone()+"\nTiming Mon-Sat "+store.getMontosatTiming()+"\nTiming Sun "+store.getSunTiming()+"\n\n");
			
		}
		StoresUI.stores.clear();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stores, menu);
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
