package com.Dmartready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Dmartready.exception.StockMovementException;
import com.Dmartready.model.StockMovement;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

	
	  @Query(value =  "SELECT * FROM stock_movement  WHERE destination_location_id = :destinationLocationId " +
	           "AND YEAR(timestamp) = :year AND MONTH(timestamp) = :month" ,nativeQuery = true)
	public List<StockMovement> findByDestinationLocationIdAndTimestampYearAndTimestampMonth(@Param("destinationLocationId") Long destinationLocationId,
			@Param("year") Integer year,
			   @Param("month") Integer month) ;
}
