package com.Dmartready.service;

import com.Dmartready.exception.StockCategoryException;
import com.Dmartready.model.StockCategory;

public interface StockCategoryService {
	public String addStockCategory(StockCategory category) throws StockCategoryException;

	public String deleteStockCategory(Long stockCategoryId) throws StockCategoryException;

	public String updateStockCategory(Long stockCategoryId , String  categoryName) throws StockCategoryException;
}
