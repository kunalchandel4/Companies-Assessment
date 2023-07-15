package com.Dmartready.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StockItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
    private int quantity;

	@Column(nullable = false)
	private Long salePrice;
	@Column(nullable = false)
	private Long marketPrice;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private StockCategory category;
}
