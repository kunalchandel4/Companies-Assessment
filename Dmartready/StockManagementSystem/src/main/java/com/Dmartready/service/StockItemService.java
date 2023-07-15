package com.Dmartready.service;

import java.util.List;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StockItem;

public interface StockItemService {
	public String addStockItem(StockItem stockItem) throws StoreItemException;

	public String updateStockItemByQuantity(Long stockItemId, Integer newQuantity) throws StoreItemException;

	public String deleteStockItem(Long stockItemId) throws StoreItemException;

	public List<StockItem> viewStockItemAtEachStore(Long storeLocationId) throws StoreItemException, StoreLocationException;

}
