package com.bakery.administration.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.common.FileManagerService;
import com.bakery.product.domain.Product;
import com.bakery.product.mapper.ProductMapper;

@Service
public class ProductAdminBO {
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
		Product product = productMapper.selectProductById(productId);
		
		//db에서 product 삭제
		int deleteRowCount = productMapper.deleteProductByProductId(productId);
		
		//이미지 파일 삭제
		if(deleteRowCount > 0 && product.getImagePath() != null) {
			fileManagerService.deleteFile(product.getImagePath());
		}
	}
	
	public void addBuyCount (int productId, int buyCount) {
		productMapper.updateBuyCount(productId, buyCount);
	}
	
}
