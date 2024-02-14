package com.bakery.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	public List<ProductEntity> findAll();
	
	public List<ProductEntity> findTop10ByOrderByCreatedAtDesc();
	
	public List<ProductEntity> findByCategory(String category);

}
