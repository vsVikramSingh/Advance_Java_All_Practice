package com.cdac.training.dao;
import java.util.List;
import com.cdac.training.bean.Product;
public interface ProductManager {
	List<Product> getProducts();
	Product getProductById(int prodId);
	void addProduct(Product product);
	void modProduct(Product product);
	void delProductById(int prodId);
	void delAllProduct();
}