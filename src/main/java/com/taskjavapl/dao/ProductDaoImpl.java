package com.taskjavapl.dao;

import com.taskjavapl.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	public Product findById(int id) {
		return getByKey(id);
	}

	public void saveProduct(Product product) {
		persist(product);
	}

	public void saveOrUpdateProduct (Product product){
		saveOrUpdate(product);
	}

	public void deleteProduct (Product product){
		delete(product);
	}

	public void deleteProductBySsn(String ssn) {
		delete(findProductBySsn(ssn));
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProduct() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}

	public Product findProductBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Product) criteria.uniqueResult();
	}
}
