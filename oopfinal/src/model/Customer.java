package model;

public class Customer {
	private String name;
	private String phoneNumber;
	private boolean updates;

	public Customer(String name, String phone, boolean updates) {
		this.name = name;
		this.phoneNumber = phone;
		this.updates = updates;
	}

	public Customer() {
		
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public boolean getUpdates() {
		return this.updates;
	}
}
