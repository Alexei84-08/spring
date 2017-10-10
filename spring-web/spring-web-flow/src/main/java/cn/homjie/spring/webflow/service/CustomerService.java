package cn.homjie.spring.webflow.service;

import cn.homjie.spring.webflow.domain.Customer;

public interface CustomerService {
	Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}