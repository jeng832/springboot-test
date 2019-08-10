package com.hashbrown.exception;

public class GroupIsNotExistException extends RuntimeException {

	private static final long serialVersionUID = 8212590033742154651L;
	public GroupIsNotExistException() {
		super();
	}
	
	public GroupIsNotExistException(String msg) {
		super(msg);
	}
}
