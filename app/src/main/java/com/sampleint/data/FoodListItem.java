package com.sampleint.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FoodListItem{

	@SerializedName("fnblist")
	private List<FnblistItem> fnblist;

	@SerializedName("TabName")
	private String tabName;

	public void setFnblist(List<FnblistItem> fnblist){
		this.fnblist = fnblist;
	}

	public List<FnblistItem> getFnblist(){
		return fnblist;
	}

	public void setTabName(String tabName){
		this.tabName = tabName;
	}

	public String getTabName(){
		return tabName;
	}
}