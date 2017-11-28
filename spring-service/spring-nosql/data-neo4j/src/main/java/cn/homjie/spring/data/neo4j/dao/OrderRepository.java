package cn.homjie.spring.data.neo4j.dao;

import cn.homjie.spring.data.neo4j.domain.Order;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface OrderRepository extends GraphRepository<Order> {

	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

}
