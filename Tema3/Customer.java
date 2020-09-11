package DomainSpecificClasses;

public class Customer {
	private int idCustomer;
	private String name;
	private String phone;
	
	
	/*
	 * Crearea constructorului clasei Customer
	 * Setez atributele prin intermediul setter-ilor
	 */
	public Customer(int idCustomer,String name,String phone){
		this.setIdCustomer(idCustomer);
		this.setName(name);
		this.setPhone(phone);
	}
	
	/*
	 * Crearea gettere si settere pentru a putea accesa si seta atributele clasei 
	 */
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/*
	 * Metoda utilizata pentru testarea operatiilor ce urmeaza a fi implentate
	 */
	public String toString(){
		return "(" + idCustomer + "," + name + "," + phone + ")";
	}
}

