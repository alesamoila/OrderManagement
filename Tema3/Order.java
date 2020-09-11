package DomainSpecificClasses;

import java.util.ArrayList;

public class Order implements Comparable<Order>{
	private int idOrder;
	private Customer customer;
	private ArrayList<Product> product;
	private ArrayList<Integer> quantity;
	/*
	 * Creez constructorul clasei Order
	 */
	public Order(int idOrder, Customer customer, ArrayList<Product> product, ArrayList<Integer> quantity){
		this.idOrder=idOrder;
		this.customer=customer;
		this.product=product;
		this.quantity=quantity;
	}
	
	/*
	 * Creez gettere si settere 
	 */
	
	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public ArrayList<Integer> getCant() {
		return quantity;
	}

	public void setCant(ArrayList<Integer> quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Product> getProd() {
		return product;
	}

	public void setProd(ArrayList<Product> product) {
		this.product = product;
	}
	/*
	 * Metoda de comparare
	 */
	public int compareTo(Order arg0) {
		return this.idOrder - arg0.idOrder;
	}
	/*
	 * Metoda utilizata pentru testarea operatiilor inainte de apelul lor in interfata.
	 */
	public String toString(){
		String str = "";
		for(int i=0; i < product.size(); i++)
			str += idOrder + "," + customer + "," + product.get(i).getName() + "," + quantity.get(i)+"\n";
		return str;
	}
}
