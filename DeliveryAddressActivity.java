package edu.colostate.cs.cs414c.Activity;

import com.example.testing.R;
import com.example.testing.R.id;
import com.example.testing.R.layout;
import com.example.testing.R.menu;

import edu.colostate.cs.cs414c.UI.CustomerUI;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DeliveryAddressActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delivery_address);
		addressLayout();
	}
	
	public void addressLayout(){
		
		RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
		TextView t1 = (TextView)findViewById(R.id.textView6);
		t1.setText("Welcome "+CustomerUI.name);
		t1 = (TextView)findViewById(R.id.textView10);
		t1.setText(CustomerUI.address1);
		t1 = (TextView)findViewById(R.id.textView11);
		t1.setText(CustomerUI.address2);
		t1 = (TextView)findViewById(R.id.textView12);
		t1.setText(CustomerUI.city);
		t1 = (TextView)findViewById(R.id.textView13);
		t1.setText(CustomerUI.state);
		t1 = (TextView)findViewById(R.id.textView14);
		t1.setText(CustomerUI.zip);
		t1 = (TextView)findViewById(R.id.textView15);
		t1.setText(CustomerUI.phone);
		t1 = (TextView)findViewById(R.id.textView16);
		t1.setText(CustomerUI.email);
		t1 = (TextView)findViewById(R.id.textView17);
		t1.setText(CustomerUI.points);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delivery_address, menu);
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
