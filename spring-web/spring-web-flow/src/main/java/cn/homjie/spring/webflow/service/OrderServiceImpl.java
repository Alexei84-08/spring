package cn.homjie.spring.webflow.service;

import cn.homjie.spring.webflow.domain.Order;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class OrderServiceImpl {
	private static final Logger LOGGER = getLogger(OrderServiceImpl.class);

	public void saveOrder(Order order) {
		LOGGER.debug("SAVING ORDER:  ");
		LOGGER.debug("   Customer:  " + order.getCustomer().getName());
		LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
		LOGGER.debug("   Payment:  " + order.getPayment());
	}
}
