package com.bakery.cart.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.bakery.product.entity.ProductEntity;

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
@Table(name = "cart")
@Getter
@Entity
public class CartEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="userId")
	private int userId;
	
	private int count;
	
	@Column(name="createdAt", updatable = false)
	@UpdateTimestamp
	private ZonedDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private ZonedDateTime updatedAt;
}
