package com.hashbrown.model;

public class PostTestResponseBody {
	private String n;
	private int a;
	
	public PostTestResponseBody(PostTest body) {
		this.n = body.getName();
		this.a = body.getAge();
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	
}
