package edu.colostate.cs.cs414c.UI;

import java.util.HashSet;
import java.util.Set;

public class StoresUI {
	
	
	
	private String storeName ;
	private String storeId ;
	private String address1 ;
	private String address2 ;
	private String city ;
	private String state ;
	private String zip ;
	private String phone ;
	private String buttonName ;
	private String montosatTiming;
	private String sunTiming ;
	public static Set<StoresUI> stores = new HashSet<StoresUI>();
	public static StoresUI selectedStore;
	
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMontosatTiming() {
		return montosatTiming;
	}
	public void setButtonName(String buttonName){
		this.buttonName = buttonName;
	}
	public String getButtonName(){
		return this.buttonName;
	}
	public void setMontosatTiming(String montosatTiming) {
		this.montosatTiming = montosatTiming;
	}
	public String getSunTiming() {
		return sunTiming;
	}
	public void setSunTiming(String sunTiming) {
		this.sunTiming = sunTiming;
	}
	
	
	

}
