package com.Dmartready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dmartready.model.StockCategory;

@Repository
public interface StockCategoryRepository extends JpaRepository<StockCategory, Long> {

}
