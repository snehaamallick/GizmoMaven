package daoimplementations;

import java.util.ArrayList;

import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import daoimplementations.ProductDAO;
import models.Product;

@Repository
public class ProductDAOImpl extends Product {
	ArrayList<Product> Products=new ArrayList<Product>();
	public ProductDAOImpl() {
	
	Product p1=new Product(1,"Samsung","Mobile",26000,"Available","Android phone");
	Product p2=new Product(2,"Mi","Mobile", 15000, "Available","Android phone");
	Product p3=new Product(3, "Dell", "Laptop", 38000, "Available","Upgradable to Windows 10");
	Product p4=new Product(4,"Lenovo","Laptop",29000, "Available","4 GB RAM");
	Product p5=new Product(5,"S7 edge", "Mobile", 60000, "Out Of Stock", "13 Mega Pixel front camera with flash");
	
	Products.add(p1);
	Products.add(p2);
	Products.add(p3);
	Products.add(p4);
	Products.add(p5);
	
	
	}
	
	
	public ArrayList<Product> productLists()
	{
		return this.Products;
	}
}
