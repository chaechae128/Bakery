package com.bakery.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.product.mapper.ProductMapper;

@Service
public class ProductBO {
	@Autowired
	private ProductMapper productMapper;
	
	//input: 파라미터들  output:x
	public void addProduct(String productName, String imagePath, int stock, int costPrice, int sellingPrice, String category) {
		productMapper.insertProduct(productName, imagePath, stock, costPrice, sellingPrice, category);
	}
}
