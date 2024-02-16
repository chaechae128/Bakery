package com.bakery.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bakery.product.domain.Product;

@Mapper
public interface ProductMapper {
	public void insertProduct(
			@Param("productName")String productName, 
			@Param("imagePath")String imagePath, 
			@Param("stock")int stock, 
			@Param("costPrice")int costPrice, 
			@Param("sellingPrice")int sellingPrice, 
			@Param("category")String category);
	
	public List<Product> selectProduct();
	
	public Product selectProductById(int productId);
	
	
	public void updateProductByProductId(
			@Param("productId")int productId, 
			@Param("productName")String productName, 
			@Param("imagePath")String imagePath, 
			@Param("stock")int stock, 
			@Param("costPrice")int costPrice, 
			@Param("sellingPrice")int sellingPrice, 
			@Param("category")String category);
	
	public int deleteProductByProductId(int productId);
	
	public List<Product> selectAll();
	

}
