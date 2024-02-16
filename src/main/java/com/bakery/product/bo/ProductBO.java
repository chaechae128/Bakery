package com.bakery.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.like.mapper.LikeMapper;
import com.bakery.product.entity.ProductEntity;
import com.bakery.product.repository.ProductRepository;

@Service
public class ProductBO {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private LikeMapper likeMapper;
	
	//메뉴 - cake
	public List<ProductEntity> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}
	
	public List<ProductEntity> selectByMenu(String menu) {
		if (menu.equals("All")) {
			return productRepository.findAll(); 
			
		} else if (menu.equals("Best")) {
			return productRepository.findTop10ByOrderByCreatedAtDesc(); 
			
		} else if (menu.equals("New")) {
			return productRepository.findTop10ByOrderByCreatedAtDesc(); 
			
		} else if (menu.equals("Cake")) {
			return productRepository.findByCategory("케이크"); 
			
		} else if (menu.equals("Dessert")) {
			return productRepository.findByCategory("디저트"); 
			
		} else if (menu.equals("Bread")) {
			return productRepository.findByCategory("빵"); 
			
		} else {
			return productRepository.findAll(); 
		}
	}
	
	public List<ProductEntity> selectBySearch(String search) {
		return productRepository.findByProductNameContaining(search); 
	}
	
	public ProductEntity selectByProductId(int productId) {
		return productRepository.findById(productId).orElse(null);
	}
	
	public boolean isLikeByUserIDProductId(int userId, int productId) {
		Integer count = likeMapper.selectLikeByUserIdProductId(userId, productId);
		if(count > 0 ) {
			return true;
		} else {
			return false;
		}
	}
}
