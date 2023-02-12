package com.cjc.app.service;

import java.util.List;

import com.cjc.app.model.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public List<Product>getAllProducts();
	
	public List<Product> deleteProduct(int pid);

	public Product getProduct(int pid);

	public List<Product> updateProduct(Product product);
}

