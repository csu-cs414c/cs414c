package edu.colostate.cs.cs414c.Activity;

import com.example.testing.R;
import com.example.testing.R.id;
import com.example.testing.R.layout;
import com.example.testing.R.menu;

import edu.colostate.cs.cs414c.UI.CustomerUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlternateDeliveryActivity extends Activity {

	EditText street,suitapt,city,state,zip,phone;
	Button nextButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alternate_delivery);
		
		street = (EditText)findViewById(R.id.editText5);
		suitapt = (EditText)findViewById(R.id.editText6);
		city = (EditText)findViewById(R.id.editText7);
		state = (EditText)findViewById(R.id.editText8);
		zip = (EditText)findViewById(R.id.editText9);
		phone = (EditText)findViewById(R.id.editText10);
		nextButton = (Button)findViewById(R.id.button11);
		
		
		nextButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(!street.getText().toString().trim().equals("")){
							if(!city.getText().toString().trim().equals("")){
								if(!state.getText().toString().trim().equals("")){
									if(!zip.getText().toString().trim().equals("")){
										if(!phone.getText().toString().trim().equals("")){
											if(CustomerUI.name!=null){
												CustomerUI.name ="Guest";
											}
											CustomerUI.address1 = street.getText().toString();
											if(suitapt.getText().toString().trim().equals("")){
												CustomerUI.address2 = suitapt.getText().toString();
											}
											CustomerUI.city = city.getText().toString();
											CustomerUI.state = state.getText().toString();
											CustomerUI.zip = zip.getText().toString();
											CustomerUI.phone = phone.getText().toString();
											// call pizza and drinks
											
										}else{
											phone.setError("Phone Number mandatory");
										}
									}else{
										zip.setError("Zip mandatory");
									}
									
								}else{
									state.setError("State Mandatory");
								}
							}else{
								city.setError("City Mandatory");
							}
						}else{
							street.setError("Street Mandatory");
						}
						
					}
				}
				);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alternate_delivery, menu);
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
