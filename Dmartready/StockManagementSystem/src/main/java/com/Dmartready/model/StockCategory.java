package com.Dmartready.model;

import java.util.LinkedHashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class StockCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String categoryName;
	@OneToMany(mappedBy = "category")

	@Column(nullable = false)
	private LinkedHashMap<Integer, StockItem> item;
}
