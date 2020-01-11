package com.example.villageapp;

import com.google.gson.annotations.SerializedName;

public class Village{

	@SerializedName("vid")
	private String vid;

	@SerializedName("vname")
	private String vname;

	@SerializedName("tid")
	private String tid;

	public void setVid(String vid){
		this.vid = vid;
	}

	public String getVid(){
		return vid;
	}

	public void setVname(String vname){
		this.vname = vname;
	}

	public String getVname(){
		return vname;
	}

	public void setTid(String tid){
		this.tid = tid;
	}

	public String getTid(){
		return tid;
	}
}