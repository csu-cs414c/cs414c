package com.example.client;

import java.util.List;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
 
public class ProductAdapter extends BaseAdapter {
  
 private List<WebSale> salelineitem;
 private LayoutInflater mInflater;
 private boolean mShowCheckbox;
 private static final String TAG1 = "Saleitemname";
 private static final String TAG2 = "status"; 
 
 public ProductAdapter(List<WebSale> salelineitem, LayoutInflater inflater, boolean showCheckbox) {
	 this.notifyDataSetChanged();
	 this.salelineitem = salelineitem;
	 mInflater = inflater;
	 mShowCheckbox = showCheckbox;
 }
 
 @Override
 public int getCount() {
  return salelineitem.size();
 }
 
 @Override
 public Object getItem(int position) {
  return salelineitem.get(position);
 }
 
 @Override
 public long getItemId(int position) {
  return position;
 }
 
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
	 
  final ViewItem item;
   
  if (convertView == null) {
	  Log.v(TAG2, "entered");
   convertView = mInflater.inflate(R.layout.item,parent, false);
   item = new ViewItem();    
    
   item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);
   item.productQuan = (TextView) convertView.findViewById(R.id.TextViewQuan);
   item.productPrice = (TextView) convertView.findViewById(R.id.TextViewPrice);
    
   item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);
    
   convertView.setTag(item);
   item.productCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			int getposition = (Integer)buttonView.getTag();
			salelineitem.get(getposition).setSaleSelect(buttonView.isChecked());	  
			
		}
	 });
  } else {
	this.notifyDataSetChanged();
   item = (ViewItem) convertView.getTag();
  }
   
  WebSale saleitem = salelineitem.get(position);
  Log.v(TAG1, saleitem.getSaleItem());

  item.productTitle.setText(saleitem.getSaleItem());
  item.productQuan.setText(saleitem.getSaleQuan()); 
  item.productPrice.setText(saleitem.getSalePrice()); 
  /*
  if(!mShowCheckbox) {
   item.productCheckbox.setVisibility(View.GONE);
  } else {
   if(saleitem.getSaleSelect() == true)
    item.productCheckbox.setChecked(true);
   else
    item.productCheckbox.setChecked(false);
  }*/
  item.productCheckbox.setTag(position); 
  item.productCheckbox.setChecked(salelineitem.get(position).getSaleSelect());
  
  //Retaining changes made to checkbox
  
  
   
   
  return convertView;
 }
  
  
 private class ViewItem {
  TextView productTitle;
  TextView productQuan;
  TextView productPrice;
  CheckBox productCheckbox;
 }
 
}
