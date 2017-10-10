package cn.homjie.spring.webflow.service;

import cn.homjie.spring.webflow.domain.Order;

public interface PricingEngine {
	public float calculateOrderTotal(Order order);
}
