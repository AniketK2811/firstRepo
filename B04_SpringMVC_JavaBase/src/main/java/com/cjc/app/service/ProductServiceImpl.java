package com.cjc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cjc.app.model.Product;
import com.cjc.app.repository.ProductReposiotry;
import com.cjc.app.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductReposiotry repo;

	public void saveProduct(Product product) 
	{
		System.out.println("***In service layer****");
		System.out.println(product.getPid());
		System.out.println(product.getPname());
		System.out.println(product.getPrice());
		repo.saveProduct(product);
		
	}

	public List<Product> getAllProducts() {
		
		List<Product> plist = repo.getAllProduct();
		
		return plist;
	}
	public List<Product> deleteProduct(int pid) {
		
		return 	repo.deleteProduct(pid);
			
		}

		public Product getProduct(int pid) {
			
			return repo.getProduct(pid);
		}

		public List<Product> updateProduct(Product product) {
			
			return repo.updateProduct(product);
		}
		
		
		
	
	
	
	
}
