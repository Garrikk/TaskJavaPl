package com.taskjavapl.service;

import com.taskjavapl.dao.ProductDao;
import com.taskjavapl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	public Product findById(int id) {
		return dao.findById(id);
	}

	public void saveProduct(Product product) {
		dao.saveProduct(product);
	}

	public void updateProduct(Product product) {
		Product entity = dao.findById(product.getId());
		if(entity!=null){
			dao.saveOrUpdateProduct(product);
		}
	}

	public void deleteProductBySsn(String ssn) {
		dao.deleteProductBySsn(ssn);
	}

	public void deleteProduct(Product product){
		dao.deleteProduct(product);
	}
	
	public List<Product> findAllProduct() {
		return dao.findAllProduct();
	}

	public Product findProductBySsn(String ssn) {
		return dao.findProductBySsn(ssn);
	}

	public boolean isProductSsnUnique(Integer id, String ssn) {
		Product product = findProductBySsn(ssn);
		return ( product == null || ((id != null) && (product.getId() == id)));
	}
	
}
