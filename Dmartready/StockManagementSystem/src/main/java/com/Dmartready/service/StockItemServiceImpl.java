package com.Dmartready.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dmartready.exception.StockCategoryException;
import com.Dmartready.exception.StockMovementException;
import com.Dmartready.exception.StoreItemException;
import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.ItemCustom;
import com.Dmartready.model.StockItem;
import com.Dmartready.model.StockMovement;
import com.Dmartready.repository.StockCategoryRepository;
import com.Dmartready.repository.StockItemRepository;
import com.Dmartready.repository.StockMovementRepository;
import com.Dmartready.repository.StoreLocationRepository;

/**
 * Service implementation for managing stock items. Handles operations such as
 * adding, updating, and deleting stock items, as well as viewing stock items at
 * specific store locations.
 */

@Service
public class StockItemServiceImpl implements StockItemService {
	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private StoreLocationRepository storeLocationRepository;
	@Autowired
	private StockMovementRepository stockMovementRepository;
	@Autowired
	private StockCategoryRepository StockCategoryRepository;

	/**
	 * Add a new stock item to the inventory. Validates the stock category exists
	 * before saving the item.
	 *
	 * @param stockItem contains the details of the item and its category
	 * @return a message indicating the successful addition of the stock item
	 * @throws StoreItemException     if the stock item is not found
	 * @throws StockCategoryException if the stock category is not found
	 */
	@Override
	public String addStockItem(StockItem stockItem) throws StoreItemException, StockCategoryException {
		// TODO Auto-generated method stub

		String msg = "New Stock-Item Added Succesfully !";

		StockCategoryRepository.findById(stockItem.getCategory().getId())
				.orElseThrow(() -> new StockCategoryException("Category does-not found"));

		stockItemRepository.save(stockItem);
		return msg;
	}

	/**
	 * Update the quantity of a stock item.
	 *
	 * @param stockItemId the ID of the stock item to be updated
	 * @param newQuantity the new quantity value to be set
	 * @return a message indicating the successful update of the stock item
	 * @throws StoreItemException if the stock item is not found
	 */
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

	/**
	 * Delete a stock item from the inventory.
	 *
	 * @param stockItemId the ID of the stock item to be deleted
	 * @return a message indicating the successful deletion of the stock item
	 * @throws StoreItemException if the stock item is not found
	 */
	@Override
	public String deleteStockItem(Long stockItemId) throws StoreItemException {
		// TODO Auto-generated method stub
		String msg = "Stock-Item Deleted Succesfully !";
		stockItemRepository.deleteById(stockItemId);
		return msg;
	}

	/**
	 * View stock items at a specific store location for a given year and month.
	 *
	 * @param storeLocationId the ID of the store location
	 * @param year            the year to filter the stock movements
	 * @param month           the month to filter the stock movements
	 * @return a list of custom item (DTO Object) objects with relevant information
	 * @throws StoreItemException     if the stock item is not found
	 * @throws StoreLocationException if the store location is not found
	 * @throws StockMovementException if no stock movements are found for the given
	 *                                filters
	 */

	@Override
	public List<ItemCustom> viewStockItemAtEachStore(Long storeLocationId, Integer year, Integer month)
			throws StoreItemException, StoreLocationException, StockMovementException {
		// TODO Auto-generated method stub
		storeLocationRepository.findById(storeLocationId)
				.orElseThrow(() -> new StoreLocationException("Store location not found"));
		List<StockMovement> modelObject = stockMovementRepository
				.findByDestinationLocationIdAndTimestampYearAndTimestampMonth(storeLocationId, year, month);

		if (modelObject.size() == 0) {
			throw new StockMovementException("No such movement track on that location");
		}

		List<ItemCustom> customItem = new ArrayList<>();

		for (StockMovement item : modelObject) {
			// Perform actions on each item in the list
			Optional<StockItem> stockItem = stockItemRepository.findById(item.getStockItem().getId());
			if (stockItem.isPresent()) {
				StockItem stock = stockItem.get();
				ItemCustom object = new ItemCustom();
				object.setId(stock.getId());
				object.setName(stock.getName());
				object.setSalePrice(stock.getSalePrice());
				object.setMarketPrice(stock.getMarketPrice());
				object.setQuantity(item.getQuantity());
				customItem.add(object);
			} else {
				throw new StoreItemException("Item Does not exits");
			}

		}

		return customItem;

	}

}
