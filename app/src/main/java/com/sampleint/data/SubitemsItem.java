package com.sampleint.data;

import com.google.gson.annotations.SerializedName;

public class SubitemsItem{

	@SerializedName("SubitemPrice")
	private String subitemPrice;

	@SerializedName("VistaSubFoodItemId")
	private String vistaSubFoodItemId;

	@SerializedName("PriceInCents")
	private String priceInCents;

	@SerializedName("VistaParentFoodItemId")
	private String vistaParentFoodItemId;

	@SerializedName("Name")
	private String name;

	public void setSubitemPrice(String subitemPrice){
		this.subitemPrice = subitemPrice;
	}

	public String getSubitemPrice(){
		return subitemPrice;
	}

	public void setVistaSubFoodItemId(String vistaSubFoodItemId){
		this.vistaSubFoodItemId = vistaSubFoodItemId;
	}

	public String getVistaSubFoodItemId(){
		return vistaSubFoodItemId;
	}

	public void setPriceInCents(String priceInCents){
		this.priceInCents = priceInCents;
	}

	public String getPriceInCents(){
		return priceInCents;
	}

	public void setVistaParentFoodItemId(String vistaParentFoodItemId){
		this.vistaParentFoodItemId = vistaParentFoodItemId;
	}

	public String getVistaParentFoodItemId(){
		return vistaParentFoodItemId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}