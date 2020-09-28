package com.rj.promotion.utils;

import java.util.HashMap;
import java.util.Map;

import com.rj.promotion.models.ProductPromotionData;


public class PromotionUtils {

	public static Map<String,ProductPromotionData> getActivePromotions() {
		Map<String,ProductPromotionData> promotions = new HashMap<>();
		promotions.put("A", new ProductPromotionData(3, 130, false, null,50,0));
		promotions.put("B", new ProductPromotionData(2, 45, false, null,30,0));
		promotions.put("C", new ProductPromotionData(1, 30, true, "D",20,1));
		promotions.put("D", new ProductPromotionData(1, 30, true, "C",15,1));
		
		return promotions;
	}
	
	public static int getPriceAfterPromotion(int productQuantity, ProductPromotionData productData) {
		int quantityRequiredForPromotion = productData.getQuantityRequiredForPromotion();
		int promotionPrice = productData.getPromotionPrice();
		int quantityAvailableForPromotion = productQuantity/quantityRequiredForPromotion;
		int remainingQuantity = productQuantity%quantityRequiredForPromotion;
		int priceAfterPromotion = quantityAvailableForPromotion*promotionPrice;
		int remainingProductPrice = remainingQuantity*productData.getProductPrice();
		
		return (priceAfterPromotion+remainingProductPrice);
	}
	
	public static int getConditionPromotionPrice(int productQuantity , int conditionalProductQuantity, ProductPromotionData productData, ProductPromotionData conditionalProductData) {
		int price = 0;
		final int oriCondtionalProductQuantity = conditionalProductQuantity;
		int conitionalProductQuantityRequired = productData.getConitionalProductQuantityRequired();
		int quantityRequiredForPromotion = productData.getQuantityRequiredForPromotion();
		if(productQuantity >= quantityRequiredForPromotion && conditionalProductQuantity >= conitionalProductQuantityRequired) {
			int j = 0;
			for(int i = 1;i <= productQuantity; i++) {
				if(i%quantityRequiredForPromotion == 0) {
					conditionalProductQuantity = conditionalProductQuantity-conitionalProductQuantityRequired;
					if(conditionalProductQuantity >= 0) {
						j++;
					}
				}
			}
			int promotionPriceForCondtionalProducts = j * productData.getPromotionPrice();
			int remaingProductQuantity = j * quantityRequiredForPromotion;
			int prodRemaining = productQuantity-remaingProductQuantity;
			int remainingProductPrice = prodRemaining * productData.getProductPrice();
			int conditionalRemaingProductQuantity = j * conitionalProductQuantityRequired;
			int conditonalProdRemaining = oriCondtionalProductQuantity-conditionalRemaingProductQuantity;
			int conditionalProductPrice = conditionalProductData.getProductPrice() * conditonalProdRemaining;
			price = promotionPriceForCondtionalProducts + remainingProductPrice + conditionalProductPrice;
		} else {
			int prodPrice = productQuantity * productData.getProductPrice();
			int conditionalProdPrice = conditionalProductData.getProductPrice() * conditionalProductQuantity;
			price = prodPrice + conditionalProdPrice;
		}
		
		return price;
	}
	
}
