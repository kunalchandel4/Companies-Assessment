package com.Dmartready.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StockItem;
import com.Dmartready.model.StockMovement;
import com.Dmartready.model.StoreLocation;
import com.Dmartready.repository.StockItemRepository;
import com.Dmartready.repository.StockMovementRepository;
import com.Dmartready.repository.StoreLocationRepository;

/**
 * Service implementation for tracking stock movements. Handles operations such
 * as tracking the movement of stock items from one location to another.
 */

@Service
public class StockMovementServiceImpl implements StockMovementService {
	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private StoreLocationRepository storeLocationRepository;

	@Autowired
	private StockMovementRepository stockMovementRepository;

	/**
	 * Track the movement of a stock item from a source location to a destination
	 * location. Creates a new stock movement record with the provided details.
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

	@Override
	public String trackStockMovement(Long stockItemId, Long sourceLocationId, Long destinationLocationId,
			Integer quantity) throws StoreLocationException, StoreItemException {
		// TODO Auto-generated method stub

		StockItem stockItem = stockItemRepository.findById(stockItemId)
				.orElseThrow(() -> new StoreItemException("Stock item not found"));
		StoreLocation sourceLocation = storeLocationRepository.findById(sourceLocationId)
				.orElseThrow(() -> new StoreLocationException("Source location not found"));
		StoreLocation destinationLocation = storeLocationRepository.findById(destinationLocationId)
				.orElseThrow(() -> new StoreLocationException("Destination location not found"));

		if (stockItem.getQuantity() < quantity) {
			throw new StoreItemException("provide a right detail of Quantity ");
		}
		StockMovement stockMovement = new StockMovement();
		stockMovement.setStockItem(stockItem);
		stockMovement.setSourceLocation(sourceLocation);
		stockMovement.setDestinationLocation(destinationLocation);
		stockMovement.setQuantity(quantity);

		stockMovement.setTimestamp(LocalDateTime.now());
		stockMovementRepository.save(stockMovement);

		return "Stock transfer successfully";
	}

}
