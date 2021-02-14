package model;

public class Customer {
	private String name;
	private int phoneNumber;
	private boolean updates;

	public Customer(String name, int phone, boolean updates) {
		this.name = name;
		this.phoneNumber = phone;
		this.updates = updates;
	}

	public Customer() {
		
	}

	public String getName() {
		return this.name;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public boolean getUpdates() {
		return this.updates;
	}
}
