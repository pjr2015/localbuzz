/**
 * 
 */
package com.cityseller.repository.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cityseller.repository.dao.ProductDao;
import com.cityseller.repository.domain.Product;

/**
 * @author jeetendra.patidar
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class ProductDaoImpl implements ProductDao {
	
	private final static Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	public Product getProductById(Long productId) {
		logger.info("ProductDaoImpl-getProductById-START for productId:"+productId);
		Product product=null;
		try{
			if(productId!=null && (!productId.equals(""))){
				product= entityManager.find(Product.class, productId);
			}
		}catch (Exception e) {
			logger.error("ProductDaoImpl-getProductById-ERRO for productId:"+productId ,e);
		}
		logger.info("ProductDaoImpl-getProductById-END for productId:"+productId);
		return product;
	}

	public List<Product> getAllProducts() {
		logger.info("ProductDaoImpl-getAllProducts-START");
		List<Product> listOfProduct =null;
		try{
		CriteriaQuery<Product> criteria = entityManager.getCriteriaBuilder().createQuery(Product.class);
	    criteria.select(criteria.from(Product.class));
	    listOfProduct = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("ProductDaoImpl-getAllProducts-ERROR",e);
		}
		logger.info("ProductDaoImpl-getAllProducts-END");
	    return listOfProduct;
	}
    @Transactional
	public Boolean saveProduct(Product product) {
		logger.info("ProductDaoImpl-saveProduct-START");
		Boolean isSave=false;
		try{
			if(product != null){
				logger.info("ProductDaoImpl-saveProduct-saving product for: "+product.toString());
				entityManager.persist(product);  //saves the saveCategory object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("ProductDaoImpl-saveProduct-product object is null");
			}
		}catch(Exception e){
			logger.error("ProductDaoImpl-saveProduct-ERROR",e);
		}
		logger.info("ProductDaoImpl-saveProduct-END ");
		return isSave;
	}

	public Boolean updateProduct(Product product) {
		logger.info("ProductDaoImpl-updateProduct-START");
		Boolean isUpdated=false;
		try{
			if(product != null){
				logger.info("ProductDaoImpl-updateProduct-updating product  for: "+product.toString());
				entityManager.merge(product);  //saves the product object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("ProductDaoImpl-updateProduct-product object is null");
			}
		}catch(Exception e){
			logger.error("ProductDaoImpl-updateProduct-ERROR",e);
		}
		logger.info("ProductDaoImpl-updateCategory-END ");
		return isUpdated;
	}

	public Boolean deleteProduct(Product product) {
		logger.info("ProductDaoImpl-deleteCategory-START");
		Boolean isDeleted=false;
		try{
			if(product != null){
				product=getProductById(product.getProductId());
				logger.info("ProductDaoImpl-deleteProduct-deleteing product detail for: "+product.toString());
				entityManager.getLockMode(product);
				entityManager.remove(product);  //delete the product object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("ProductDaoImpl-deleteProduct-product object is null");
			} 
		}catch(Exception e){
			logger.error("ProductDaoImpl-deleteProduct-ERROR",e);
		}
		logger.info("ProductDaoImpl-deleteProduct-END ");
		return isDeleted;
	}
}
