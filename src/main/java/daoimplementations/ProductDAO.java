package daoimplementations;
import java.util.List;

import models.Product;
public interface ProductDAO {
	public void addProduct(Product product);
    public void updateProduct(Product product);
    public Product getProduct(int id);
    public void deleteProduct(int id);
    public List<Product> getProducts();

}
