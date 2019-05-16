package com.boot;

public class Sender {
	
	String SName;
	
	public Sender() {}
	
	public Sender(String SName) {
		this.SName = SName;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}
	
	public String toString() {
		return "Sender name is: " + SName;
	}

}
