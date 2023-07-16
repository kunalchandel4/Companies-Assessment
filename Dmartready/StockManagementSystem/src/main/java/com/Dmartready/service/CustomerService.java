package com.Dmartready.service;

import java.util.List;

import com.Dmartready.exception.CustomerException;
import com.Dmartready.model.Customer;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);

	public Customer getCustomerDetailsByEmail(String email) throws CustomerException;

	public List<Customer> getAllCustomerDetails() throws CustomerException;

}
