package edu.colostate.cs.cs414c.Activity;

import java.util.concurrent.ExecutionException;

import com.example.testing.R;
import com.example.testing.R.id;
import com.example.testing.R.layout;
import com.example.testing.R.menu;

import edu.colostate.cs.cs414c.UI.CustomerUI;
import edu.colostate.cs.cs414c.WebCall.LoginWebCall;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerLoginActivity extends Activity {

	EditText userName;
	EditText password;
	TextView invalidText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_login);
		
		//Intent intent = getIntent();
		userName = (EditText)findViewById(R.id.editText2);
		password = (EditText)findViewById(R.id.editText1);
		Button siginButton = (Button)findViewById(R.id.button2);
		invalidText = (TextView)findViewById(R.id.textView4);
		
		siginButton.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						System.out.println("username entered : "+userName.getText().toString());
						System.out.println("Password entered : "+password.getText().toString());
						AsyncTask result = new LoginWebCall().execute(userName.getText().toString(),password.getText().toString());
						try {
							// execute the web call and get the result in xml varialbe
							String xml = (String)result.get();
							if(CustomerUI.warning!=null){
								System.out.println(CustomerUI.warning);
								invalidText.setText("Invalid UserName/Password.");
								CustomerUI.warning=null;
							}else{
								invalidText.setText("");
								Intent intent = new Intent(CustomerLoginActivity.this,DeliveryAddressActivity.class);
								startActivity(intent);
							}
							
							// update android manifest after that. for making calls over internet
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
		
	}
	
	
	
	/*public void addressLayout(){
		LinearLayout LL = new LinearLayout(this);
	    LL.setBackgroundColor(Color.CYAN);
	    LL.setOrientation(LinearLayout.VERTICAL);

	    LayoutParams LLParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);

	    LL.setWeightSum(6f);
	    LL.setLayoutParams(LLParams);
	    
	    
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customer_login, menu);
		return true;
	}

	public void cancelCustomerLoginButtonClick(View view){
		Intent intent = new Intent(this,WelcomeActivity.class);
		startActivity(intent);
	}
	
	public void signInLoginButtonClick(View view){
		
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
