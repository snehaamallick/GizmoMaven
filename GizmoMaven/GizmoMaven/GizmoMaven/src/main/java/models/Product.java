package models;

public class Product {
 String productId;
 String productName;
 String category;
 double price;
 String status;
 String description;
 
public Product() {
}

public Product(String productId, String productName, String category, double price, String status, String description) {

	this.productId = productId;
	this.productName = productName;
	this.category = category;
	this.price = price;
	this.status = status;
	this.description = description;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
 
 
}
