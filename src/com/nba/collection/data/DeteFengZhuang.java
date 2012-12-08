package com.nba.collection.data;

import java.io.Serializable;

public class DeteFengZhuang implements Serializable{
	private int photo;
	//private String names;
	private String feature;
	private String maked;
	//private String jianli;
	public DeteFengZhuang(int photo,String feature,String maked){
		this.photo=photo;
		this.feature=feature;
		this.maked=maked;
	}
	public int getPhoto() {
		return photo;
	}
	public void setPhoto(int photo) {
		this.photo = photo;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getMaked() {
		return maked;
	}
	public void setMaked(String maked) {
		this.maked = maked;
	}
	
}
