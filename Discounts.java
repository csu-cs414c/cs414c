package edu.colostate.cs.cs414c.model;

import edu.colostate.cs.cs414c.utils.DbConnection;

public class Discounts {

	private Sale sale;
	private String couponNumber=null;
	private int frequentPoints=0;;
	private DbConnection db;
	private float amountAfterDiscount;
	
	public Discounts(Sale sale){
		this.sale = sale;
		db = new DbConnection();
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
	
	public int getFrequentPoints(){
		return this.frequentPoints;
	}
	
	public void calculateTotalAfterDiscounts(){
		if(this.couponNumber!=null){
			amountAfterDiscount = (sale.getTotalAmountBeforeTax() - getCouponAmount());
		}
		if(this.frequentPoints > 0){
			amountAfterDiscount = (sale.getTotalAmountBeforeTax() - (frequentPoints/10));
		}
	}
	
	
	
	
}
