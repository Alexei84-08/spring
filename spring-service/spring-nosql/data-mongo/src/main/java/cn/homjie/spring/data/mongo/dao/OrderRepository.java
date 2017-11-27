package cn.homjie.spring.data.mongo.dao;

import cn.homjie.spring.data.mongo.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String>, OrderRepositoryCustom {

	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);

	@Query("{customer:'Chuck Wagon'}")
	List<Order> findChucksOrders();

}
