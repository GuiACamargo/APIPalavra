package com.gft.palavra.exception;

public class PalavraException extends RuntimeException {
	
	private static final long serialVersionUID = -7461723216573927617L;
	
	private String message;

	public PalavraException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
