package com.bakery.order.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public int insertOrder(Map<String, Object> map);
}
