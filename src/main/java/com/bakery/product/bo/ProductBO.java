package com.bakery.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.common.FileManagerService;
import com.bakery.product.domain.Product;
import com.bakery.product.mapper.ProductMapper;

@Service
public class ProductBO {
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	//input: 파라미터들  output:x
	public void addProduct(String productName, MultipartFile file, int stock, int costPrice, int sellingPrice, String category) {
		//BO : MultipartFile -> imagePath
		String imagePath = null;
		imagePath = fileManagerService.saveFile(file);
		
		productMapper.insertProduct(productName, imagePath, stock, costPrice, sellingPrice, category);
	}
	
	//input:x output:List<Product>
	public List<Product> selectProduct(){
		return productMapper.selectProduct();
	}
	
	//input:productId output:product
	public Product selectProductById(int productId) {
		return productMapper.selectProductById(productId);
	}
	
	//input: 파라미터들  output:x
	public void updateProductByProductId(int productId, String productName, MultipartFile file, int stock, int costPrice, int sellingPrice, String category) {
		//BO : MultipartFile -> imagePath
		String imagePath = null;
		imagePath = fileManagerService.saveFile(file);
		
		productMapper.updateProductByProductId(productId, productName, imagePath, stock, costPrice, sellingPrice, category);
	}
	
	//input:productId output:x
	public void deleteProductByProductId(int productId) {
		productMapper.deleteProductByProductId(productId);
	}
}
