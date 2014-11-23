package edu.colostate.cs.cs414c.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTable;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class Sale {
	JTable table;
	private DbConnection db;
	
	private Set<SaleLineItem> listOfSaleLineItems= new HashSet<SaleLineItem>();
	private float totalAmount = 0.0f;
	private float totalAmountBeforeTax = 0.0f;
	private String couponNumber;
	private int frequentPoints=0;
	private float totalAmountDiscountBeforeTax = 0.0f;
	private float taxDiscount = 0.0f;
	private float totalAmountAfterDiscount = 0.0f;
	
	private float taxAmount = 0.0f;
	
	private float couponAmount = 0.0f;
	private float frequentPointAmount = 0.0f;
	
	public Sale(Set<SaleLineItem> listOfSaleLineItems){
		this.listOfSaleLineItems = listOfSaleLineItems;
		db = new DbConnection();
	}
	
	public Sale(JTable table){
		this.table = table;
	}
	
	public float calculateSaleTotal() {
		float total = 0;
		for(int i=0; i<table.getRowCount(); i++) {
			boolean isChecked = (Boolean) table.getValueAt(i, 2);
			if(!isChecked) {
				float selected = (float) table.getValueAt(i, 1);
				System.out.println(selected);
				total = total + selected;
				System.out.println(total);
			}			
		}
		return total;
		
	}
	
	public void setTax(float taxAmount){
		this.taxAmount = taxAmount;
	}
	
	public float getTax(){
		return taxAmount;
	}
	
	
	public void setTotalAmountBeforeTax(float totalAmountBeforeTax){
		this.totalAmountBeforeTax  = totalAmountBeforeTax;
	}
	
	public float getTotalAmountBeforeTax(){
		return this.totalAmountBeforeTax;
	}
	
	public void setTotalAmount(float totalAmount){
		this.totalAmount = totalAmount;
	}
	
	public float getTotalAmount(){
		return this.totalAmount;
	}
	
	public void setCouponAmount(float couponAmount){
		this.couponAmount = couponAmount;
	}
	
	public float getTotalAmountCouponBeforeTax(){
		return this.couponAmount;
	}
	
	public void setFrequentAmount(float frequentPointAmount){
		this.frequentPointAmount = frequentPointAmount;
	}
	
	public float getFrequentAmount(){
		return this.frequentPointAmount;
	}
	
	public void calculateTotal(){
		
		Iterator<SaleLineItem> itr = listOfSaleLineItems.iterator();
		while(itr.hasNext()){
			totalAmountBeforeTax = totalAmountBeforeTax + itr.next().getPrice();
		}
		System.out.println("before tax"+ totalAmountBeforeTax);
		
		setTotalAmountBeforeTax(totalAmountBeforeTax);
		
		
		taxAmount = calculateTax(totalAmountBeforeTax);
		setTax(taxAmount);
		System.out.println("Tax "+ taxAmount);
		totalAmount = totalAmountBeforeTax + taxAmount;
		setTotalAmount(totalAmount);
		System.out.println("Total amount "+ totalAmount);
		 
	}
	
	public void calculateTotalAfterDiscount(){
		totalAmountDiscountBeforeTax = getTotalAmountBeforeTax() - (getCouponAmount() + getFrequentPointsAmount());
		
		taxDiscount = calculateTax(totalAmountDiscountBeforeTax);
		totalAmountAfterDiscount = totalAmountDiscountBeforeTax + taxDiscount;
		
	}
		
	/*public float addSaleLineItem(SaleLineItem saleLineItem,float couponAmount,int points){
		listOfSaleLineItems.add(saleLineItem);
		totalAmount = totalAmount+ saleLineItem.getPrice();
		if(couponAmount!=0.0f){
			applyCoupon(couponAmount);
		}
		if(points!=0){
			applyFrequentPoint(points);
		}
		tax = calculateTax(totalAmount);
		return totalAmount;
	}*/
	
	
	
	public float getTotalAmountDiscountBeforeTax(){
		return this.totalAmountDiscountBeforeTax;
	}
	
	public float getTaxDiscount(){
		return this.taxDiscount;
	}
	
	public float getTotalAmountAfterDiscount(){
		return this.totalAmountAfterDiscount;
	}
	
	public void setCoupon(String couponNumber){
		this.couponNumber = couponNumber;
	}
	
	public float getCouponAmount(){
		float couponAmount = db.getCouponAmount(this.couponNumber);
		return couponAmount;
	}
	
	public void setFrequentPoints(int frequentPoints){
		this.frequentPoints = frequentPoints;
	}
	
	public float getFrequentPointsAmount(){
		return (this.frequentPoints/10);
	}
	
	
	public float calculateTax(float totalAmountBeforeTax){
		return (float) (totalAmountBeforeTax*8.25)/100;
	}
	
	
	
	public float applyFrequentPoint(int points){
		if(points>0){
			return (totalAmountBeforeTax - points/10);
		}
		return totalAmountBeforeTax;
	}

}
