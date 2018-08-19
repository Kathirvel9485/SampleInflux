package com.sampleint.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MockyBaseResponse{

	@SerializedName("Currency")
	private String currency;

	@SerializedName("FoodList")
	private List<FoodListItem> foodList;

	@SerializedName("status")
	private Status status;

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setFoodList(List<FoodListItem> foodList){
		this.foodList = foodList;
	}

	public List<FoodListItem> getFoodList(){
		return foodList;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}
}