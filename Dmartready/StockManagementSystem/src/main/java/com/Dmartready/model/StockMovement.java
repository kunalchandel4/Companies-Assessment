package com.Dmartready.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StockMovement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_item_id", nullable = false )
    private StockItem stockItem;
    
    @ManyToOne
    @JoinColumn(name = "source_location_id", nullable = false)
    private StoreLocation sourceLocation;
    
    @ManyToOne
    @JoinColumn(name = "destination_location_id", nullable = false)
    private StoreLocation destinationLocation;
    
    @Column(nullable = false)
    private int quantity;
    
//    @CreationTimestamp
    @Column(nullable = false)
    
    private LocalDateTime timestamp;
}
