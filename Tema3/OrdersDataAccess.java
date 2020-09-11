package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

import BusinessLogic.OrderProcessing;
import DomainSpecificClasses.Customer;
import DomainSpecificClasses.Order;
import DomainSpecificClasses.Product;

public class OrdersDataAccess {
	DBConnection dbC = new DBConnection();
	/*
	 * Metoda pentru stergerea unei comenzi specificate prin "id" prin
	 * intermediul interfetei. Modificarea este vizibila atat in baza de date
	 * cat si in interfata si in obiectele java.
	 */
	public void deleteOrder(int id) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("DELETE FROM `order` WHERE idOrder=" + id + ";");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Metoda care extrage intr-un ArrayList id-urile comenzilor
	 */
	public ArrayList<Integer> getOrdersId() {
		try {
			Statement stmt = dbC.connect().createStatement();
			ResultSet rs = stmt.executeQuery("select * from `order`;");
			ArrayList<Integer> idO = new ArrayList<Integer>();
			while (rs.next()) {
				idO.add(rs.getInt(1));
			}
			return idO;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/*
	 * Metoda care introduce comenzile treeMap-ul din OrderProcessing iar apoi
	 * returneaza un obiect de tip OrderProcessing
	 */
	public OrderProcessing getOrders() {

		ArrayList<Integer> idO = new ArrayList<Integer>();
		idO = getOrdersId();
		// System.out.println("da");
		TreeSet<Order> tree = new TreeSet<Order>();

		for (int i = 0; i < idO.size(); i++)

			tree.add(creareOrder(idO.get(i)));

		OrderProcessing op = new OrderProcessing(tree);
		return op;
	}

	/*
	 * Metoda care extrage comenzile din baza de date pe baza id-ului si le
	 * introduce intr-un order
	 */
	private Order creareOrder(int id) {
		Order ord = null;
		try {
			Statement stmt = dbC.connect().createStatement();
			/*
			 * ResultSet rs = stmt.executeQuery(
			 * "SELECT * FROM order_has_product JOIN order ON order.idOrder=order_has_product.idOrder JOIN customer ON order.idCustomer=customer.idCustomer JOIN product ON product.idProduct=order_has_product.idProduct WHERE order_has_product.idOrder="
			 * + id + ";");
			 */
			ResultSet rs = stmt.executeQuery(
					"select * from `order_has_product` join `order` on `order`.idOrder=`order_has_product`.idOrder join customer on `order`.idCustomer=`customer`.idCustomer join product on `product`.idProduct=`order_has_product`.idProduct where `order_has_product`.idOrder="
							+ id + ";");
			ArrayList<Integer> cant = new ArrayList<Integer>();
			ArrayList<Product> pro = new ArrayList<Product>();
			Customer user = null;
			int orderId = 0;
			while (rs.next()) {
				orderId = rs.getInt(1);
				// System.out.println(orderId);
				user = new Customer(rs.getInt(6), rs.getString(7), rs.getString(8));
				pro.add(new Product(rs.getInt(9), rs.getString(10), rs.getDouble(11)));
				cant.add(rs.getInt(3));
			}
			ord = new Order(orderId, user, pro, cant);
			// System.out.println(ord.size());
			return ord;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	/*
	 * Metoda pentru inserarea unuei comenzi in baza de date ( aici se insereaza
	 * doar id-ul comenzii
	 * 
	 * si id-ul clientului in tabeLA Order)
	 */
	public void insertOrder(Order o) {
		try {
			Statement stmt = dbC.connect().createStatement();
			stmt.execute("INSERT INTO `order` (idOrder,idCustomer) VALUES (" + o.getIdOrder() + ","
					+ o.getCustomer().getIdCustomer() + ");");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/*
	 * Metoda pentru inserarea unuei comenzi in baza de date ( aici se insereaza
	 * doar id-ul comenzii,
	 * 
	 * id-ul produsului si cantitatea in tabelA Order_has_product)
	 */
	public void insertOrderHasProduct(Order o) {
		try {
			for (int i = 0; i < o.getProd().size(); i++) {
				Product p = o.getProd().get(i);
				int pro = p.getIdProduct();
				int cant = o.getCant().get(i);
				int id = o.getIdOrder();
				
				Statement stmt = dbC.connect().createStatement();
				stmt.execute("SET FOREIGN_KEY_CHECKS=0");
				String str = "INSERT INTO order_has_product values(" + id + "," + pro + "," + cant + ");";
				stmt.executeUpdate(str);
				stmt.execute("SET FOREIGN_KEY_CHECKS=1");
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}


