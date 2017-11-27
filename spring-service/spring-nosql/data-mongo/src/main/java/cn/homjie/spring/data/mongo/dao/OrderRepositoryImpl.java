package cn.homjie.spring.data.mongo.dao;

import cn.homjie.spring.data.mongo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

	@Autowired
	private MongoOperations mongoOps;

	@Override
	public List<Order> findOrdersByType(String type) {
		String t = type.equals("NET") ? "WEB" : type;

		Criteria where = Criteria.where("type").is(t);
		Query query = Query.query(where);

		return mongoOps.find(query, Order.class);
	}
}
