package com.Dmartready.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dmartready.exception.CustomerException;
import com.Dmartready.model.Customer;
import com.Dmartready.repository.CustomerRepository;

/**
 * Service implementation for managing customers. Handles operations such as
 * registering a new customer, retrieving customer details by email, and
 * retrieving all customer details.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Register a new customer.
	 *
	 * @param customer the Customer object containing the details of the customer to
	 *                 be registered
	 * @return the registered customer
	 * @throws CustomerException if there is an error during the registration
	 *                           process
	 */

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		customerRepository.findByEmail(customer.getEmail())
				.orElseThrow(() -> new CustomerException("Email already exits"));

		return customerRepository.save(customer);

	}

	/**
	 * Get the customer details by email.
	 *
	 * @param email the email of the customer
	 * @return the customer details
	 * @throws CustomerException if the customer is not found with the given email
	 */

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerException("Customer Not found with Email: " + email));
	}

	/**
	 * Get all customer details.
	 *
	 * @return a list of all customers
	 * @throws CustomerException if there are no customers found
	 */
	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty())
			throw new CustomerException("No Customer find");
		return customers;
	}

}
