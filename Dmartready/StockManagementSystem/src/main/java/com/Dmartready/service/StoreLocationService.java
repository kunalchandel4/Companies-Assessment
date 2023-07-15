package com.Dmartready.service;

import com.Dmartready.exception.StoreLocationException;
import com.Dmartready.model.StoreLocation;

public interface StoreLocationService {

	public String addStoreLocation(StoreLocation storeLocation) throws StoreLocationException;

	public String deleteStoreLocation(Long storeLocationId) throws StoreLocationException;

}
