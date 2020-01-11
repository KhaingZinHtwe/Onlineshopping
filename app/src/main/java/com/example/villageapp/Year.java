package com.example.villageapp;

import com.google.gson.annotations.SerializedName;

public class Year{

	@SerializedName("vid")
	private String vid;

	@SerializedName("area")
	private String area;

	@SerializedName("no_of_home")
	private String noOfHome;

	@SerializedName("iid")
	private String iid;

	@SerializedName("year")
	private String year;

	@SerializedName("total_population")
	private String totalPopulation;

	@SerializedName("female")
	private String female;

	@SerializedName("male")
	private String male;

	public void setVid(String vid){
		this.vid = vid;
	}

	public String getVid(){
		return vid;
	}

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setNoOfHome(String noOfHome){
		this.noOfHome = noOfHome;
	}

	public String getNoOfHome(){
		return noOfHome;
	}

	public void setIid(String iid){
		this.iid = iid;
	}

	public String getIid(){
		return iid;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setTotalPopulation(String totalPopulation){
		this.totalPopulation = totalPopulation;
	}

	public String getTotalPopulation(){
		return totalPopulation;
	}

	public void setFemale(String female){
		this.female = female;
	}

	public String getFemale(){
		return female;
	}

	public void setMale(String male){
		this.male = male;
	}

	public String getMale(){
		return male;
	}
}