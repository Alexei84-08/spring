package cn.homjie.spring.data.mongo.dao;

import cn.homjie.spring.data.mongo.domain.Order;

import java.util.List;

public interface OrderRepositoryCustom {

	List<Order> findOrdersByType(String type);
}
