package com.cjc.app.repository;

import java.util.List;

import com.cjc.app.model.Product;

public interface ProductReposiotry {

	public void saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public List<Product> deleteProduct(int pid);

	public Product getProduct(int pid);

	public List<Product> updateProduct(Product product);
	
	
}
