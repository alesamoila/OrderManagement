package DomainSpecificClasses;

public class Product implements Comparable<Product> {
	private int idProduct;
	private String name;
	private double price;
	
	/*
	 * Crearea constructorului clasei Product
	 */
	
	public Product(int idProduct, String name, double price){
		this.idProduct = idProduct;
		this.setName(name);
		this.setPrice(price);
	}
	
	/*
	 * Creez gettere si settere
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	/*
	 * Metoda pentru testarea operatiilor inaintea introducerii acestora in interfata.
	 */
	public String toString(){
		return "(" + idProduct + "," + name + "," + price + ")";
	}
	
	/*
	 * Suprascriu metoda compareTo pentru verifcarea corectitudinii datelor introduse
	 */
	
	public int compareTo(Product p) {
		if(idProduct < p.getIdProduct())
			return -1;
		else if(idProduct > p.getIdProduct())
			return 1;
		else
			return 0;
	}

}

