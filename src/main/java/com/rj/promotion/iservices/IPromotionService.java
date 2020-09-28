package com.rj.promotion.iservices;

import com.rj.promotion.models.ProductQuantity;

public interface IPromotionService {

	public Integer calculatePriceOfProducts(ProductQuantity pq);

}
