package daoimplementations;

import java.util.ArrayList;

import models.Product;

public class ProductDAOImpl extends Product {
	ArrayList<Product> Products=new ArrayList<Product>();
	public ProductDAOImpl() {
	
	Product p1=new Product("P1","Samsung","Mobile",26000,"Available","Android phone");
	Product p2=new Product("P2","Mi","Mobile", 15000, "Available","Android phone");
	Product p3=new Product("P3", "Dell", "Laptop", 38000, "Available","Upgradable to Windows 10");
	Product p4=new Product("P4","Lenovo","Laptop",29000, "Available","4 GB RAM");
	Product p5=new Product("P5","S7 edge", "Mobile", 60000, "Out Of Stock", "13 Mega Pixel front camera with flash");
	
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
