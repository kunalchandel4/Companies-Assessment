package com.Dmartready.service;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;

public interface StockMovementService {
	
	public String trackStockMovement(Long stockItemId, Long sourceLocationId, 
            Long destinationLocationId, Integer quantity) throws StoreLocationException,StoreItemException;
}
