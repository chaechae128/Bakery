package com.bakery.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakery.product.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	
	
	public List<ProductEntity> findTop10ByOrderByCreatedAtDesc();
	
	public List<ProductEntity> findByCategory(String category);
	public List<ProductEntity> findByProductNameContaining(String menu);
	
	

}
