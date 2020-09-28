package com.rj.promotion.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromotionData {

	private int quantityRequiredForPromotion;
	private int promotionPrice;
	private boolean conditionalPromotion;
	private String promotionDependentOn;
	private int productPrice;
	private int conitionalProductQuantityRequired;
	
}
