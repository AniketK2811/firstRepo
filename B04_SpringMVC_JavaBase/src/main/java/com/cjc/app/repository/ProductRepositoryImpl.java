package com.cjc.app.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.cjc.app.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductReposiotry {

	@Autowired
	private SessionFactory factory;

	public void saveProduct(Product product) {

		Session session = factory.openSession();

		session.save(product);

		session.beginTransaction().commit();
		
		System.out.println("Data Saved");

	}

	public List<Product> getAllProduct() {
		
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Product");
		
		List<Product> list = query.getResultList();
		
		return  list;
	}
	public List<Product> deleteProduct(int pid) {

		Session session = factory.openSession();

		Product product = session.get(Product.class, pid);

		Transaction tx = session.beginTransaction();
		session.delete(product);
		tx.commit();
		System.out.println("Data Deleted");

		return getAllProduct();
	}

	public Product getProduct(int pid) {

		Session session = factory.openSession();

		Product product = session.get(Product.class, pid);
		return product;
	}

	public List<Product> updateProduct(Product product) {

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(product);
		tx.commit();

		Query query = session.createQuery("from Product");

		List<Product> list = query.getResultList();

		return list;
	}

}
