package com.taskjavapl.service;

import com.taskjavapl.model.Product;

import java.util.List;

public interface ProductService {

	Product findById(int id);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProductBySsn(String ssn);

	void deleteProduct(Product product);

	List<Product> findAllProduct();

	Product findProductBySsn(String ssn);

	boolean isProductSsnUnique(Integer id, String ssn);
	
}
