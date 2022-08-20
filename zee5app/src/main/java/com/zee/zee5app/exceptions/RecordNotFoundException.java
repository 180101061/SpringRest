package com.zee.zee5app.exceptions;

public class RecordNotFoundException extends Exception {

	//tostring method
	//super call
	public RecordNotFoundException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage(); 
	}
}
