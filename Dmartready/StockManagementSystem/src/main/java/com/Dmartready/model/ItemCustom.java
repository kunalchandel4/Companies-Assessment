package com.Dmartready.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemCustom {
	private Long id;

	private String name;

	private Integer quantity;

	private Long salePrice;

	private Long marketPrice;
}
