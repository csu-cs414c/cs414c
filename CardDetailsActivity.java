package edu.colostate.cs.cs414c.Activity;

import com.example.testing.R;
import com.example.testing.R.id;
import com.example.testing.R.layout;
import com.example.testing.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CardDetailsActivity extends Activity {

	EditText cardNumber;
	EditText name;
	EditText cvv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_details);
		Button next = (Button)findViewById(R.id.button25);
		cardNumber = (EditText) findViewById(R.id.editText25);
		name = (EditText) findViewById(R.id.editText26);
		cvv = (EditText) findViewById(R.id.editText27);
		
		next.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(!cardNumber.getText().toString().equals("")){
							if(cardNumber.getText().length()!=16){
								cardNumber.setError("Please enter proper card number");
							}
							if(!name.getText().toString().equals("")){
								if(!cvv.getText().toString().equals("")){
									if(cvv.getText().length()!=3){
										cvv.setError("Please enter proper CVV");
									}
									// Payment Final Screen
									
								}else{
									cvv.setError("Please enter CVV");
								}
							}else{
								name.setError("Please enter Name");
							}
						}else{
							cardNumber.setError("Card Number Mandatory");
						}
						
					}
				});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.card_details, menu);
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
