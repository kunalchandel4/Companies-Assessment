package com.Dmartready.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StockItem;
import com.Dmartready.service.StockItemServiceImpl;
import com.Dmartready.service.StockMovementServiceImpl;

@RestController
@RequestMapping("/stock")

public class StockManagementSystemController {

	@Autowired
	private StockItemServiceImpl stockItemServiceImpl;
	@Autowired
	private StockMovementServiceImpl stockMovementServiceImpl;

	@GetMapping("/view/{storeLocationId}")
	public ResponseEntity<List<StockItem>> viewStockItemAtEachStoreHandler(@PathVariable Long storeLocationId)
			throws StoreItemException, StoreLocationException {

		return new ResponseEntity<>(stockItemServiceImpl.viewStockItemAtEachStore(storeLocationId), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addStockItemHandler(@RequestBody StockItem stockItem) throws StoreItemException {

		return new ResponseEntity<>(stockItemServiceImpl.addStockItem(stockItem), HttpStatus.CREATED);
	}

	@PutMapping("/update/{stockItemId}/{newQuantity}")
	public ResponseEntity<String> updateStockItemHandler(@PathVariable Long stockItemId,@PathVariable Integer newQuantity)
			throws StoreItemException {

		return new ResponseEntity<>(stockItemServiceImpl.updateStockItemByQuantity(stockItemId, newQuantity),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{stockItemId}")
	public ResponseEntity<String> deleteStockItemHandler( @PathVariable Long stockItemId) throws StoreItemException {

		return new ResponseEntity<>(stockItemServiceImpl.deleteStockItem(stockItemId), HttpStatus.OK);
	}
               
	@PostMapping("/move/{stockItemId}/{sourceLocationId}/{destinationLocationId}/{quantity}")
	public ResponseEntity<String> trackStockMovementHandler(@PathVariable Long stockItemId,
			@PathVariable Long sourceLocationId, @PathVariable Long destinationLocationId,
			@PathVariable int quantity) throws StoreLocationException, StoreItemException {

		return new ResponseEntity<>(stockMovementServiceImpl.trackStockMovement(stockItemId, sourceLocationId, destinationLocationId, quantity), HttpStatus.OK);
	}

}
