package com.Dmartready.service;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StockItem;

public interface StockItemService {
	public String addStockItem(StockItem item) throws StoreItemException;

	public String updateStockItemByQuantity(Long stockItemId, Integer newQuantity) throws StoreItemException;

	public String deleteStockItem(Long stockItemId) throws StoreItemException;

	public String viewStockItemAtEachStore(Long storeLocationId) throws StoreItemException, StoreLocationException;

}
