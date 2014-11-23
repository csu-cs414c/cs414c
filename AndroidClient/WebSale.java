package com.example.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebSale {
	 String saleitem;
	 String saleid;
	 String salequan;
	 String saleprice;
	 boolean saleselect;
	 static List<WebSale> saleset = new ArrayList<WebSale>();
	 //static List<WebSale> salecouponset = new ArrayList<WebSale>();
	
	public WebSale(String saleitem, String salequan, String saleprice, boolean saleselect){
		this.saleitem = saleitem;
		this.salequan = salequan;
		this.saleprice = saleprice;
		this.saleselect = saleselect;
	}
	
	public String getSaleID(){
		return this.saleid;
	}
	
	public String getSaleItem(){
		return this.saleitem;
	}
	
	public String getSaleQuan(){
		return this.salequan;
	}
	
	public String getSalePrice(){
		return this.saleprice;
	}
	
	public boolean getSaleSelect(){
		return this.saleselect;
	}
	
	public void setSaleID(String saleid){
		this.saleid = saleid;
	}
	
	public void setSaleItem(String saleitem){
		this.saleitem = saleitem;
	}
	
	public void setSaleQuan(String salequan) {
		this.salequan = salequan;
	}
	
	public void setSalePrice(String saleprice) {
		this.saleprice = saleprice;
	}
	
	public void setSaleSelect(boolean saleselect){
		this.saleselect = saleselect;
	}
	
	public List<WebSale> getSaleList(){
		return this.saleset;
	}
}
