package BusinessLogic;

//import java.util.Map;
import java.util.TreeMap;

import DomainSpecificClasses.Product;

public class WarehouseAdministration {
	private TreeMap<Product, Integer> wharehouse = new TreeMap<Product, Integer>();

	/*
	 * Constructorul clasei
	 */
	public WarehouseAdministration(){
		wharehouse = new TreeMap<Product, Integer>();
	}
	
	/*
	 * Metoda pentru adaugarea unui produs nou in depozit. Este introdusa de asemenea si cantitatea
	 */
	public void addProduct(Product product, Integer quantity ){
		wharehouse.put(product, quantity);
	}
	
	/*
	 * Metoda care returneaza TreeMap-ul creat in interiorul constructorului clasei WarehouseAdministration
	 */
	public TreeMap<Product,Integer> getWarehouse(){
		return wharehouse;
	}
	
	/*
	 * Metoda care returneaza ultimul id in treeMap in vederea adaugarii acestuia
	 */
	public int getId(){
		return wharehouse.lastKey().getIdProduct();
	}
	
	/*
	 * Metoda care cauta un produs in functie de id
	 */
	public Product searchProduct(int id){
		for(Product p:wharehouse.keySet()){
			if(p.getIdProduct() == id){
				return p;
			}
		}
		return null;
	}
	
	/*
	 * Metoda care returneaza starea stocului curent
	 */
	public String getStatus(int id){
		String s = "";
		if (this.getWarehouse().get(this.searchProduct(id)) < 50){
			s = "UnderStock";
		}
		else if (this.getWarehouse().get(this.searchProduct(id))>300){
			s = "OverStock";
		}
		return s;
	}
	
	/*
	 * Metoda pentru modificarea cantitatii unui produs
	 */
	public void updateQuantity(int id, int quantity){
		wharehouse.replace(this.searchProduct(id), quantity);
	}
	
	/*
	 * Metoda pentru stergerea unui produs
	 */
	public void delete(Product p){
		wharehouse.remove(p);
	}
	
	/*
	 * Metoda pentru testarea operatiilor inaintea introducerii lor in interfata
	 */
	public String toString(){
		String str = "";
		for(Product p:wharehouse.keySet())
			str += p.toString() + "  c: " + wharehouse.get(p) + "\n";
		return str;
	}
}
