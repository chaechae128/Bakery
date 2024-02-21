package com.bakery.product.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.cart.domain.Cart;
import com.bakery.like.domain.Like;
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
	
	public List<ProductEntity> selectBylikeList(List<Like> likeList) {
		List<ProductEntity> productList = new ArrayList<>();
		for(int i = 0; i<likeList.size(); i++) {
			int productId = likeList.get(i).getProductId();
			productList.add(productRepository.findById(productId).orElse(null));
		}
		return productList;
	}
	
	public List<ProductEntity> selectBycartList(List<Cart> cartList) {
		List<ProductEntity> productList = new ArrayList<>();
		for(int i = 0; i<cartList.size(); i++) {
			int productId = cartList.get(i).getProductId();
			productList.add(productRepository.findById(productId).orElse(null));
		}
		return productList;
	}
	
	public List<ProductEntity> selectByOrder(List<Integer> productIdList) {
		List<ProductEntity> productList = new ArrayList<>();
		for(int i = 0; i<productIdList.size(); i++) {
			int productId = productIdList.get(i);
			productList.add(productRepository.findById(productId).orElse(null));
		}
		return productList;
	}
}
