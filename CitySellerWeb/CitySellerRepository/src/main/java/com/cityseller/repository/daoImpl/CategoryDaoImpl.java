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

import com.cityseller.repository.dao.CategoryDao;
import com.cityseller.repository.domain.Category;

/**
 * @author jeetendra.patidar
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class CategoryDaoImpl implements CategoryDao {
	
	private final static Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	public Category getCatoryById(Long categoryId) {
		logger.info("CategoryDaoImpl-getCatoryById-START for categoryId:"+categoryId);
		Category category=null;
		try{
			if(categoryId!=null && (!categoryId.equals(""))){
				category= entityManager.find(Category.class, categoryId);
			}
		}catch (Exception e) {
			logger.error("CategoryDaoImpl-getCatoryById-ERRO for userId:"+categoryId ,e);
		}
		logger.info("CategoryDaoImpl-getCatoryById-END for userId:"+categoryId);
		return category;
	}

	public List<Category> getCategories() {
		logger.info("CategoryDaoImpl-getCategories-START");
		List<Category> listOfCategories =null;
		try{
		CriteriaQuery<Category> criteria = entityManager.getCriteriaBuilder().createQuery(Category.class);
	    criteria.select(criteria.from(Category.class));
	     listOfCategories = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("CategoryDaoImpl-getCategories-ERROR",e);
		}
		logger.info("CategoryDaoImpl-getCategories-END");
	    return listOfCategories;
	}
    @Transactional
	public Boolean saveCategory(Category category) {
		logger.info("CategoryDaoImpl-saveCategory-START");
		Boolean isSave=false;
		try{
			if(category != null){
				logger.info("CategoryDaoImpl-saveCategory-saving user detail for: "+category.toString());
				entityManager.persist(category);  //saves the saveCategory object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("CategoryDaoImpl-saveCategory-user details object is null");
			}
		}catch(Exception e){
			logger.error("CategoryDaoImpl-saveCategory-ERROR",e);
		}
		logger.info("CategoryDaoImpl-saveCategory-END ");
		return isSave;
	}

	public Boolean updateCategory(Category category) {
		logger.info("CategoryDaoImpl-updateCategory-START");
		Boolean isUpdated=false;
		try{
			if(category != null){
				logger.info("CategoryDaoImpl-updateCategory-updating category detail for: "+category.toString());
				entityManager.merge(category);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("CategoryDaoImpl-updateCategory-user details object is null");
			}
		}catch(Exception e){
			logger.error("CategoryDaoImpl-updateCategory-ERROR",e);
		}
		logger.info("CategoryDaoImpl-updateCategory-END ");
		return isUpdated;
	}

	public Boolean deleteCategory(Category category) {
		logger.info("CategoryDaoImpl-deleteCategory-START");
		Boolean isDeleted=false;
		try{
			if(category != null){
				category=getCatoryById(category.getCategoryId());
				logger.info("CategoryDaoImpl-deleteCategory-deleteing category detail for: "+category.toString());
				entityManager.getLockMode(category);
				entityManager.remove(category);  //delete the category object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("CategoryDaoImpl-deleteCategory-category  object is null");
			} 
		}catch(Exception e){
			logger.error("CategoryDaoImpl-deleteCategory-ERROR",e);
		}
		logger.info("CategoryDaoImpl-deleteCategory-END ");
		return isDeleted;
	}
}
