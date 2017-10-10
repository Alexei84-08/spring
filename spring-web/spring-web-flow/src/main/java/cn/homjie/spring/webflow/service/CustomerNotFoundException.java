package cn.homjie.spring.webflow.service;

public class CustomerNotFoundException extends Exception {
	private static final long serialVersionUID = 1617682267485574430L;

	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
