package com.example.client;

import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CouponWebServiceActivity extends Activity{

	public String couponcode;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_service_coupon_point);
		EditText txtcoupon = (EditText)findViewById(R.id.textcoupon);
		txtcoupon.addTextChangedListener(new TextWatcher() {
			 
			   public void afterTextChanged(Editable s) {
			   }
			 
			   public void beforeTextChanged(CharSequence s, int start, 
			     int count, int after) {
			   }
			 
			   public void onTextChanged(CharSequence s, int start, 
			     int before, int count) {
				   couponcode = s.toString();
			   }
			  });
		
		
		
	}
	
	public void buttonApplyDiscount(View view) {
		AsyncTask result = new DiscountWebCall(couponcode).execute();
		
		try {
			WebSale.saleset = (List<WebSale>)result.get();
			Intent intent = new Intent(CouponWebServiceActivity.this, SaleWebServiceActivity.class);
			startActivity(intent);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
