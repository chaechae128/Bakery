package com.bakery.like.domain;



import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Like {

	private int id;
	private int productId;
	private int userId;
	private Date createdAt;
	private Date updatedAt;
}
