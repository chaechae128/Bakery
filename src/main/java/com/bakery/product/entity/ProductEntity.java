package com.bakery.product.entity;

import java.time.ZonedDateTime;

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
	private String productName;
	
	@Column(name="imagePath")
	private String imagePath;
	
	private int stock;
	
	@Column(name="costPrice")
	private int costPrice;
	
	@Column(name="sellingPrice")
	private int sellingPrice;
	
	private String category;
	
	@Column(name="createdAt", updatable = false)
	@UpdateTimestamp
	private ZonedDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private ZonedDateTime updatedAt;
	
	@Column(name="buyCount")
	private int buyCount;
}
