package com.bakery.product.entity;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "product")
@Getter
@Entity
public class ProductEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="productName")
	private int productName;
	
	@Column(name="imagePath")
	private int imagePath;
	
	private int stock;
	
	@Column(name="costPrice")
	private int costPrice;
	
	@Column(name="sellingPrice")
	private int sellingPrice;
	
	private int category;
	
	@Column(name="createdAt", updatable = false)
	@UpdateTimestamp
	private int createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private int updatedAt;
}
