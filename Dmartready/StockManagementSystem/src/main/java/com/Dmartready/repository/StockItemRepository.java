package com.Dmartready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dmartready.model.StockItem;
import com.Dmartready.model.StoreLocation;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {

	public List<StockItem> findByStoreLocation(StoreLocation storeLocation);
}
