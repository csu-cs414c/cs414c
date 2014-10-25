package edu.colostate.cs414c.model;

public abstract class Item {
	
	
	private int id;
	private String name;
	private float price;
	private ItemStatus status;
	
	enum ItemStatus {
		startedPreparation,
		finishedPrepatation,
		delivered
	}
	
	public abstract float calculateItemPrice();
	
	public Item(){
		
	}
	
	public Item(int id, String name,float price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	public void setStatus(ItemStatus status){
		if(status.equals(ItemStatus.startedPreparation)){
			this.status = ItemStatus.startedPreparation;
		}else if(status.equals(ItemStatus.finishedPrepatation)){
			this.status = ItemStatus.finishedPrepatation;
		}else if(status.equals(ItemStatus.delivered)){
			this.status = ItemStatus.delivered;
		}
	}
	
	public ItemStatus getStatus(){
		return this.status;
	}

}