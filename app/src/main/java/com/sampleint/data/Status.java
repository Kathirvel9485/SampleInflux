package com.sampleint.data;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("Description")
	private String description;

	@SerializedName("Id")
	private String id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}