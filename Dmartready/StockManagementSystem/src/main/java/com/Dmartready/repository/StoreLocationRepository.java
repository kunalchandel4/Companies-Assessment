package com.Dmartready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dmartready.model.StoreLocation;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long>{

}
