package com.bakery.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
	public void insertProduct(
			@Param("productName")String productName, 
			@Param("imagePath")String imagePath, 
			@Param("stock")int stock, 
			@Param("costPrice")int costPrice, 
			@Param("sellingPrice")int sellingPrice, 
			@Param("category")String category);
}
