package com.Dmartready.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dmartready.exception.CustomerException;
import com.Dmartready.exception.StockCategoryException;
import com.Dmartready.exception.StockMovementException;
import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.Customer;
import com.Dmartready.model.ItemCustom;
import com.Dmartready.model.StockItem;
import com.Dmartready.service.CustomerService;
import com.Dmartready.service.StockItemServiceImpl;
import com.Dmartready.service.StockMovementServiceImpl;

@RestController
@RequestMapping("/stock")
/**
 * Controller for managing stock items in the stock management system. Provides
 * endpoints for adding, updating, deleting, and viewing stock items.
 */
public class StockManagementSystemController {

	@Autowired
	private StockItemServiceImpl stockItemServiceImpl;
	@Autowired
	private StockMovementServiceImpl stockMovementServiceImpl;

	/**
	 * View stock items at each store location for a given year and month.
	 *
	 * @param storeLocationId the ID of the store location
	 * @param year            the year to filter the stock movements
	 * @param month           the month to filter the stock movements
	 * @return a list of custom item objects with relevant information
	 * @throws StoreItemException     if the stock item is not found
	 * @throws StoreLocationException if the store location is not found
	 * @throws StockMovementException if no stock movements are found for the given
	 *                                filters
	 */
	@GetMapping("/view/{storeLocationId}/{year}/{month}")
	public ResponseEntity<List<ItemCustom>> viewStockItemAtEachStoreHandler(@PathVariable Long storeLocationId,
			@PathVariable Integer year, @PathVariable Integer month)
			throws StoreItemException, StoreLocationException, StockMovementException {

		return new ResponseEntity<>(stockItemServiceImpl.viewStockItemAtEachStore(storeLocationId, year, month),
				HttpStatus.OK);
	}

	/**
	 * Add a new stock item to the inventory.
	 *
	 * @param stockItem contains the details of the stock item to be added
	 * @return a message indicating the successful addition of the stock item
	 * @throws StoreItemException     if the stock item is not found
	 * @throws StockCategoryException if the stock category is not found
	 */

	@PostMapping("/add")
	public ResponseEntity<String> addStockItemHandler(@RequestBody StockItem stockItem)
			throws StoreItemException, StockCategoryException {

		return new ResponseEntity<>(stockItemServiceImpl.addStockItem(stockItem), HttpStatus.CREATED);
	}

	/**
	 * Update the quantity of a stock item.
	 *
	 * @param stockItemId the ID of the stock item to be updated
	 * @param newQuantity the new quantity value to be set
	 * @return a message indicating the successful update of the stock item
	 * @throws StoreItemException if the stock item is not found
	 */
	@PutMapping("/update/{stockItemId}/{newQuantity}")
	public ResponseEntity<String> updateStockItemHandler(@PathVariable Long stockItemId,
			@PathVariable Integer newQuantity) throws StoreItemException {

		return new ResponseEntity<>(stockItemServiceImpl.updateStockItemByQuantity(stockItemId, newQuantity),
				HttpStatus.ACCEPTED);
	}

	/**
	 * Delete a stock item from the inventory.
	 *
	 * @param stockItemId the ID of the stock item to be deleted
	 * @return a message indicating the successful deletion of the stock item
	 * @throws StoreItemException if the stock item is not found
	 */
	@DeleteMapping("/delete/{stockItemId}")
	public ResponseEntity<String> deleteStockItemHandler(@PathVariable Long stockItemId) throws StoreItemException {

		return new ResponseEntity<>(stockItemServiceImpl.deleteStockItem(stockItemId), HttpStatus.OK);
	}

	/**
	 * Track the movement of a stock item from a source location to a destination
	 * location.
	 *
	 * @param stockItemId           the ID of the stock item being transferred
	 * @param sourceLocationId      the ID of the source location from where the
	 *                              stock item is moved
	 * @param destinationLocationId the ID of the destination location where the
	 *                              stock item is transferred
	 * @param quantity              the quantity of stock item being transferred
	 * @return a message indicating the successful stock transfer
	 * @throws StoreLocationException if the source or destination location is not
	 *                                found
	 * @throws StoreItemException     if the stock item is not found
	 */

	@PostMapping("/move/{stockItemId}/{sourceLocationId}/{destinationLocationId}/{quantity}")
	public ResponseEntity<String> trackStockMovementHandler(@PathVariable Long stockItemId,
			@PathVariable Long sourceLocationId, @PathVariable Long destinationLocationId, @PathVariable int quantity)
			throws StoreLocationException, StoreItemException {

		return new ResponseEntity<>(stockMovementServiceImpl.trackStockMovement(stockItemId, sourceLocationId,
				destinationLocationId, quantity), HttpStatus.OK);
	}

	@Autowired
	private CustomerService customerService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_" + customer.getRole().toUpperCase());
		Customer registeredCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email)
			throws CustomerException {
		Customer customer = customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException {
		List<Customer> customers = customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
	}

	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth) throws CustomerException {
		System.out.println(auth); // this Authentication object having Principle object details
		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		return new ResponseEntity<>(customer.getName() + " Logged In Successfully", HttpStatus.ACCEPTED);
	}

}
