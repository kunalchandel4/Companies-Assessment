package com.Dmartready.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dmartready.exception.CustomerException;
import com.Dmartready.model.Customer;
import com.Dmartready.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);

	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerException("Customer Not found with Email: " + email));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty())
			throw new CustomerException("No Customer find");
		return customers;
	}

}