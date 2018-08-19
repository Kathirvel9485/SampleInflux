package com.sampleint.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FnblistItem{

	@SerializedName("VegClass")
	private String vegClass;

	@SerializedName("ItemPrice")
	private String itemPrice;

	@SerializedName("ImageUrl")
	private String imageUrl;

	@SerializedName("ImgUrl")
	private String imgUrl;

	@SerializedName("Name")
	private String name;

	@SerializedName("OtherExperience")
	private String otherExperience;

	@SerializedName("Cinemaid")
	private String cinemaid;

	@SerializedName("PriceInCents")
	private String priceInCents;

	@SerializedName("subitems")
	private List<SubitemsItem> subitems;

	@SerializedName("SevenStarExperience")
	private String sevenStarExperience;

	@SerializedName("TabName")
	private String tabName;

	@SerializedName("SubItemCount")
	private int subItemCount;

	@SerializedName("VistaFoodItemId")
	private String vistaFoodItemId;

	public void setVegClass(String vegClass){
		this.vegClass = vegClass;
	}

	public String getVegClass(){
		return vegClass;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return imgUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOtherExperience(String otherExperience){
		this.otherExperience = otherExperience;
	}

	public String getOtherExperience(){
		return otherExperience;
	}

	public void setCinemaid(String cinemaid){
		this.cinemaid = cinemaid;
	}

	public String getCinemaid(){
		return cinemaid;
	}

	public void setPriceInCents(String priceInCents){
		this.priceInCents = priceInCents;
	}

	public String getPriceInCents(){
		return priceInCents;
	}

	public void setSubitems(List<SubitemsItem> subitems){
		this.subitems = subitems;
	}

	public List<SubitemsItem> getSubitems(){
		return subitems;
	}

	public void setSevenStarExperience(String sevenStarExperience){
		this.sevenStarExperience = sevenStarExperience;
	}

	public String getSevenStarExperience(){
		return sevenStarExperience;
	}

	public void setTabName(String tabName){
		this.tabName = tabName;
	}

	public String getTabName(){
		return tabName;
	}

	public void setSubItemCount(int subItemCount){
		this.subItemCount = subItemCount;
	}

	public int getSubItemCount(){
		return subItemCount;
	}

	public void setVistaFoodItemId(String vistaFoodItemId){
		this.vistaFoodItemId = vistaFoodItemId;
	}

	public String getVistaFoodItemId(){
		return vistaFoodItemId;
	}
}