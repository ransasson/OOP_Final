package model;

public class Product {
	
	private String name;
	private int storeCost;
	private int customerCost;
	private Customer customer;
	
	
	public Product(String name, int storeCost, int customerCost, Customer customer) {
		this.name = name;
		this.customerCost = customerCost;
		this.storeCost = storeCost;
		this.customer = new Customer();
		this.customer = customer;
	}
	
	
	public String getProductName() {
		return this.name;
	}
	
	public int getStroreCost() {
		return this.storeCost;
	}
	public int getCustomerCost() {
		return this.customerCost;
	}
	public Customer getProductCustomer() {
		return this.customer;
	}
}
