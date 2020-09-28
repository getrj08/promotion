package com.rj.promotion.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.rj.promotion.iservices.IPromotionService;
import com.rj.promotion.models.ProductPromotionData;
import com.rj.promotion.models.ProductQuantity;
import com.rj.promotion.utils.PromotionUtils;

@Service
public class PromotionService implements IPromotionService {

	@Override
	public Integer calculatePriceOfProducts(ProductQuantity pq) {

		Map<String, ProductPromotionData> activePromotions = PromotionUtils.getActivePromotions();
		int productQuantityA = pq.getProductQuantityA();
		ProductPromotionData productApromotionData = activePromotions.get("A");
		int priceA = PromotionUtils.getPriceAfterPromotion(productQuantityA, productApromotionData);
		
		int productQuanityB = pq.getProductQuantityB();
		ProductPromotionData productBpromotionData = activePromotions.get("B");
		int priceB = PromotionUtils.getPriceAfterPromotion(productQuanityB, productBpromotionData);
		
		int productQuanityC = pq.getProductQuantityC();
		ProductPromotionData productCpromotionData = activePromotions.get("C");
		// price of C and D is calculated together as they are dependent on each other for promotion
		int priceCD = 0;
		if(productCpromotionData.isConditionalPromotion()) {
			String promotionDependentOn = productCpromotionData.getPromotionDependentOn();
			ProductPromotionData conditionalProductData = activePromotions.get(promotionDependentOn);
			int conditonalProductQuantity = pq.getConditionalProductQuantity(promotionDependentOn);
			priceCD = PromotionUtils.getConditionPromotionPrice(productQuanityC, conditonalProductQuantity, productCpromotionData, conditionalProductData);
			
		}
		
		return (priceA + priceB + priceCD);
	}

	

}
