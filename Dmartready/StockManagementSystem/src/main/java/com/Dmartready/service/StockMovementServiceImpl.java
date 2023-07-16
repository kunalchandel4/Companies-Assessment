package com.Dmartready.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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

@Service
public class StockMovementServiceImpl implements StockMovementService {
	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private StoreLocationRepository storeLocationRepository;

	@Autowired
	private StockMovementRepository stockMovementRepository;

	@Override
	public String trackStockMovement(Long stockItemId, Long sourceLocationId, Long destinationLocationId, int quantity)
			throws StoreLocationException, StoreItemException {
		// TODO Auto-generated method stub

		StockItem stockItem = stockItemRepository.findById(stockItemId)
				.orElseThrow(() -> new StoreItemException("Stock item not found"));
		StoreLocation sourceLocation = storeLocationRepository.findById(sourceLocationId)
				.orElseThrow(() -> new StoreLocationException("Source location not found"));
		StoreLocation destinationLocation = storeLocationRepository.findById(destinationLocationId)
				.orElseThrow(() -> new StoreLocationException("Destination location not found"));

		StockMovement stockMovement = new StockMovement();
		stockMovement.setStockItem(stockItem);
		stockMovement.setSourceLocation(sourceLocation);
		stockMovement.setDestinationLocation(destinationLocation);
		stockMovement.setQuantity(quantity);
//		LocalDateTime localDateTime =
//		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//		
//		stockMovement.setTimestamp( new java.sql.Timestamp(System.currentTimeMillis()));
		stockMovement.setTimestamp(LocalDateTime.now());
		stockMovementRepository.save(stockMovement);

		return "Stock transfer successfully";
	}

}
