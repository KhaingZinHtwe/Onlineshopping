package com.example.villageapp;

import com.google.gson.annotations.SerializedName;


public class TownShip{

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("tname")
	private String tname;

	@SerializedName("description")
	private String description;

	@SerializedName("tid")
	private String tid;

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setTname(String tname){
		this.tname = tname;
	}

	public String getTname(){
		return tname;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTid(String tid){
		this.tid = tid;
	}

	public String getTid(){
		return tid;
	}
}