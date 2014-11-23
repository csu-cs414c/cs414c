package com.example.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {
	
	public static final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void buttonClick(View view) {
    	Intent intent = new Intent(this, PizzaWebServiceActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	startActivity(intent);
    }
    
    public void buttondrinkClick(View view) {
    	Intent intent = new Intent(this, DrinkWebServiceActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	startActivity(intent);
    }
    
    public void buttonaddonClick(View view) {
    	Intent intent = new Intent(this, AddonWebServiceActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
