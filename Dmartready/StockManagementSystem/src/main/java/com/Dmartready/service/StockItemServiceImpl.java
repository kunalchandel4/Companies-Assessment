package com.Dmartready.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StockItem;
import com.Dmartready.model.StoreLocation;
import com.Dmartready.repository.StockItemRepository;
import com.Dmartready.repository.StoreLocationRepository;

@Service
public class StockItemServiceImpl implements StockItemService {
	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private StoreLocationRepository storeLocationRepository;

	@Override
	public String addStockItem(StockItem stockItem) throws StoreItemException {
		// TODO Auto-generated method stub
		String msg = "New Stock-Item Added Succesfully !";

		stockItemRepository.save(stockItem);
		return msg;
	}

	@Override
	public String updateStockItemByQuantity(Long stockItemId, Integer newQuantity) throws StoreItemException {
		// TODO Auto-generated method stub

		String msg = "Stock-Item Updated Succesfully !";
		StockItem stockItem = stockItemRepository.findById(stockItemId)
				.orElseThrow(() -> new StoreItemException("Stock item not found"));
		stockItem.setQuantity(newQuantity);
		stockItemRepository.save(stockItem);
		return msg;

	}

	@Override
	public String deleteStockItem(Long stockItemId) throws StoreItemException {
		// TODO Auto-generated method stub
		String msg = "Stock-Item Deleted Succesfully !";
		stockItemRepository.deleteById(stockItemId);
		return msg;
	}

	@Override
	public List<StockItem> viewStockItemAtEachStore(Long storeLocationId)
			throws StoreItemException, StoreLocationException {
		// TODO Auto-generated method stub
		StoreLocation storeLocation = storeLocationRepository.findById(storeLocationId)
				.orElseThrow(() -> new StoreLocationException("Store location not found"));
		return stockItemRepository.findByStoreLocation(storeLocation);

	}

}
