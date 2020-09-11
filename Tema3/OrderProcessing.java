package BusinessLogic;

import java.util.TreeSet;

import DomainSpecificClasses.Order;

public class OrderProcessing {
	private TreeSet<Order> order;

	/*
	 * Constructorul clasei OPDept
	 */
	public OrderProcessing(TreeSet<Order> tree) {
		this.order = tree;
	}

	/*
	 * Metoda pentru adaugare comanda noua
	 */
	public void addOrder(Order ord) {
		order.add(ord);
	}

	/*
	 * Metoda pentru stergere comanda
	 */
	public void deleteOrder(Order ord) {
		order.remove(ord);
	}

	/*
	 * Metoda care returneaza TreeSet-ul de comenzi
	 */
	public TreeSet<Order> getOrderProcessing() {
		return order;
	}

	/*
	 * Metoda care returneaza comanda cu id-ul "id" pe care utilizatorul il
	 * introduce in interfata se face cautare dupa id
	 */
	public Order searchOrder(int id) {
		for (Order o : order) {
			// System.out.println(o.getIdOrder());
			if (o.getIdOrder() == id) {
				return o;
			}
		}
		return null;
	}

	/*
	 * Metoda folosita pentru testarea operatiilor pentru verificarea
	 * functionalitatiilor lor inainte de includerea lor in interfata
	 */
	public String toString() {
		String s = "";
		for (Order o : order) {
			s += o.toString();
		}
		return s;
	}
}
