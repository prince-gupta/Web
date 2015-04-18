package com.practice.rest.enums;

public enum CustomerStatus {
	
	CREATED(101,"Created"),
	DELETED(102,"Deleted"),
	NOT_DELETED(103,"Not Deleted"),
	NOTFOUND(104,"Not Found"),
	FOUND(105,"Found");
	
	private int value;
	private String displayValue;
	private CustomerStatus(int value,String displayValue) {
		this.setValue(value);
		this.displayValue = displayValue;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
