package com.example.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SaleWebServiceActivity extends Activity {
	private static final String TAG1 = "SaleObjectsize"; 
	private static final String TAG2 = "AddItemButton";
	private static final String TAG3 = "SaleRemItemName";
	private static final String TAG4 = "SelPosition";
	private static final String TAG5 = "SelItem"; 
	//private static final String TAG4 = "AddItemButton";
	Set<String> al;
	static ArrayList<String> selpizzatopping = new ArrayList<String>();
	static String basename;
	static String quantity;
	static String pizzaname;
	static String type;
	private ProductAdapter mProductAdapter;
	private List<WebSale> sale;
	private WebPizza editsalepizza;
	boolean flag = false;
	
	
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_service_sale);
		Intent intent = getIntent();
		type = intent.getStringExtra("type");
		if(type.equals("one")){
			selpizzatopping = intent.getStringArrayListExtra("selpizzatopping");
			basename = intent.getStringExtra("selpizzabase");
			quantity = intent.getStringExtra("selpizzaquan");
			pizzaname = intent.getStringExtra("selpizzaname");
			
			AsyncTask result = new SaleWebCall(selpizzatopping, basename, quantity, pizzaname).execute();
			try{
				sale = (List<WebSale>)result.get();
				//salearray = sale.toArray(new WebSale[sale.size()]);
				//Log.v(TAG1, salearray.length+"");
				final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
				mProductAdapter = new ProductAdapter(sale, getLayoutInflater(), true);
				mProductAdapter.notifyDataSetChanged();
				listViewCatalog.setAdapter(mProductAdapter);
				listViewCatalog.setOnItemClickListener(new OnItemClickListener() {						 
					   @Override
					   public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
						   Log.v(TAG4, position+"");
						   WebSale item = (WebSale) listViewCatalog.getItemAtPosition(position);
						   Log.v(TAG5, item.getSaleItem());
						   AsyncTask result = new EditCartWebCall(item.getSaleID()).execute();
							try{
								editsalepizza = (WebPizza)result.get();								
								Intent intent = new Intent(SaleWebServiceActivity.this, WebServiceToppingActivity.class);
								intent.putExtra("editpizzaname", editsalepizza.getPizzaItem());
								intent.putStringArrayListExtra("edittoppinglist", (ArrayList<String>) editsalepizza.getPizzaTopping());
								intent.putExtra("editpizzabase", editsalepizza.getPizzaBase());
								intent.putExtra("editpizzaquan", editsalepizza.getPizzaQuan());
								intent.putExtra("type", "edit");
								startActivity(intent);
							}catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ExecutionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						   
					   }
				});
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} else if(type.equals("two")){
				
				final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
				mProductAdapter = new ProductAdapter(WebSale.saleset, getLayoutInflater(), true);
				mProductAdapter.notifyDataSetChanged();
				listViewCatalog.setAdapter(mProductAdapter);
				listViewCatalog.setOnItemClickListener(new OnItemClickListener() {						 
					   @Override
					   public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
						   Log.v(TAG4, position+"");
						   WebSale item = (WebSale) listViewCatalog.getItemAtPosition(position);
						   Log.v(TAG5, item.getSaleItem());
						   AsyncTask result = new EditCartWebCall(item.getSaleID()).execute();
							try{
								editsalepizza = (WebPizza)result.get();								
								Intent intent = new Intent(SaleWebServiceActivity.this, WebServiceToppingActivity.class);
								intent.putExtra("editpizzaname", editsalepizza.getPizzaItem());
								intent.putStringArrayListExtra("edittoppinglist", (ArrayList<String>) editsalepizza.getPizzaTopping());
								intent.putExtra("editpizzabase", editsalepizza.getPizzaBase());
								intent.putExtra("editpizzaquan", editsalepizza.getPizzaQuan());
								intent.putExtra("type", "edit");
								startActivity(intent);
							}catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ExecutionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						   
					   }
				});
				
				
				
			}
				
				//Adding Sub-total, tax and total fields
				//LinearLayout ll = (LinearLayout)findViewById(R.id.LinearLayout01);
				//LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				//LinearLayout.LayoutParams lparams = (LinearLayout.LayoutParams) ll.getLayoutParams();
				//lparams.rightMargin = 20;
				//ll.setLayoutParams(lparams);
				//LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				//lp.rightMargin = 20;
				TextView textsubtotal = (TextView)findViewById(R.id.text1);
				//TextView textsubtotal = new TextView(this);				
				textsubtotal.setText("Sub-total");
				//textsubtotal.setLayoutParams(lp);
		        //ll.addView(textsubtotal);
		        
		        TextView textsubtotaldis = (TextView)findViewById(R.id.text2);
		        System.out.println("WebPayment subtotal: "+WebPayment.paymentsubtotal);		        
		        textsubtotaldis.setText("$"+WebPayment.paymentsubtotal);
		        //textsubtotaldis.setLayoutParams(lp);
				//ll.addView(textsubtotaldis);
				
		        TextView texttax = (TextView)findViewById(R.id.text3);				
				texttax.setText("Tax");
				//texttax.setLayoutParams(lp);
		        //ll.addView(texttax);
		        
				TextView texttaxdis = (TextView)findViewById(R.id.text4);	
		        System.out.println("WebPayment tax: "+WebPayment.paymenttax);
		        texttaxdis.setText("$"+WebPayment.paymenttax);
		        //texttaxdis.setLayoutParams(lp);
				//ll.addView(texttaxdis, lp);
				
		        TextView texttotal = (TextView)findViewById(R.id.text5);				
				texttotal.setText("Total");
				//texttotal.setLayoutParams(lp);
		        //ll.addView(texttotal);
		        
				TextView texttotaldis = (TextView)findViewById(R.id.text6);	
		        System.out.println("WebPayment total: "+WebPayment.paymenttotal);
		        texttotaldis.setText("$"+WebPayment.paymenttotal);
		        //texttotaldis.setLayoutParams(lp);
				//ll.addView(texttotaldis);
				flag = true;		
				
				
			 
		
		
	}
	
	public void buttonClickAddItem(View view) {
		Log.v(TAG2, "entered");
    	Intent intent = new Intent(this, MainActivity.class);
    	//intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	startActivity(intent);
    }
	
	public void buttonClickCoupon(View view) {
		Log.v(TAG2, "Click Coupon entered");
		Intent intent = new Intent(this, CouponWebServiceActivity.class);
    	//intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	startActivity(intent);
	}
	
	
	
	public void buttonClickRemoveItem(View view) {
		Log.v(TAG2, "Remove item entered "+sale.size());
		List<WebSale> tempsale = new ArrayList<WebSale>();
		tempsale.addAll(sale);
		for(WebSale obj : tempsale){
			if(obj.getSaleSelect() == true){
				Log.v(TAG3, obj.getSaleItem());
				AsyncTask result = new DeleteItemsCartWebCall(obj.getSaleID()).execute();
				try{
					sale = (List<WebSale>)result.get();
					//salearray = sale.toArray(new WebSale[sale.size()]);
					//Log.v(TAG1, salearray.length+"");
					final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
					mProductAdapter = new ProductAdapter(sale, getLayoutInflater(), true);
					mProductAdapter.notifyDataSetChanged();
					listViewCatalog.setAdapter(mProductAdapter);
					TextView textsubtotaldis = (TextView)findViewById(R.id.text2);
			        System.out.println("WebPayment subtotal: "+WebPayment.paymentsubtotal);		        
			        textsubtotaldis.setText("$"+WebPayment.paymentsubtotal);
			        
			        TextView texttaxdis = (TextView)findViewById(R.id.text4);	
			        System.out.println("WebPayment tax: "+WebPayment.paymenttax);
			        texttaxdis.setText("$"+WebPayment.paymenttax);
			        
			        TextView texttotaldis = (TextView)findViewById(R.id.text6);	
			        System.out.println("WebPayment total: "+WebPayment.paymenttotal);
			        texttotaldis.setText("$"+WebPayment.paymenttotal);
					
					
					
				}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
				
		}
    	//Intent intent = new Intent(this, SaleWebServiceActivity.class);
    	//intent.putExtra(EXTRA_MESSAGE, "hello new activity");
    	//startActivity(intent);
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
