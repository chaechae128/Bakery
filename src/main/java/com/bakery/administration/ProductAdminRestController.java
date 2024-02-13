package com.bakery.administration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bakery.administration.bo.ProductAdminBO;

@RestController
@RequestMapping("/product")
public class ProductAdminRestController {
	@Autowired
	private ProductAdminBO productAdminBO;
	
	/**
	 * 관리자 - 상품 등록API
	 * @param productName
	 * @param stock
	 * @param costPrice
	 * @param sellingPrice
	 * @param category
	 * @param file
	 * @return
	 */
	@PostMapping("/add")
	public Map<String, Object> add(
			@RequestParam("productName") String productName,
			@RequestParam("stock") int stock,
			@RequestParam("costPrice") int costPrice,
			@RequestParam("sellingPrice") int sellingPrice,
			@RequestParam("category") String category,
			@RequestParam("file") MultipartFile file){
		//db insert
		productAdminBO.addProduct(productName, file, stock, costPrice, sellingPrice, category);
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	/**
	 * 관리자 - 상품 수정API
	 * @param productId
	 * @param productName
	 * @param stock
	 * @param costPrice
	 * @param sellingPrice
	 * @param category
	 * @param file
	 * @return
	 */
	@PostMapping("/update")
	public Map<String, Object> update(
			@RequestParam("productId") int productId,
			@RequestParam("productName") String productName,
			@RequestParam("stock") int stock,
			@RequestParam("costPrice") int costPrice,
			@RequestParam("sellingPrice") int sellingPrice,
			@RequestParam("category") String category,
			@RequestParam("file") MultipartFile file){
		//db insert
		productAdminBO.updateProductByProductId(productId, productName, file, stock, costPrice, sellingPrice, category);
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("productId") int productId){
		//db delete
		productAdminBO.deleteProductByProductId(productId);
		
		//응답값
				Map<String, Object> result = new HashMap<>();
				result.put("code", 200);
				result.put("result", "성공");
				
				return result;
	}
	
	
	
}
