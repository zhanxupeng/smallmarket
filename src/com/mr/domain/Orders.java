package com.mr.domain;

public class Orders {
	private int id;
	private String name;
	private String picture;
	private int number;
	private int userid;
	public Orders(){
		
	}
	public Orders(int id,String name,String picture,int number,int userid){
		this.id=id;
		this.name=name;
		this.picture=picture;
		this.number=number;
		this.userid=userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
