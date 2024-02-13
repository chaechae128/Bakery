package com.bakery.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.product.domain.Product;
import com.bakery.product.mapper.ProductMapper;

@Service
public class ProductBO {
	@Autowired
	private ProductMapper productMapper;
	
	//input:x
	public List<Product> selectAll(){
		return productMapper.selectAll();
	}
}
