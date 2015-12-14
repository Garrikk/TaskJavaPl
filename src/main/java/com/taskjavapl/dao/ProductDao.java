package com.taskjavapl.dao;

import com.taskjavapl.model.Product;

import java.util.List;

public interface ProductDao {

	Product findById(int id);

	void saveProduct(Product product);

	void saveOrUpdateProduct (Product product);
	
	void deleteProductBySsn(String ssn);
	
	List<Product> findAllProduct();

	Product findProductBySsn(String ssn);

	void deleteProduct (Product product);
}
