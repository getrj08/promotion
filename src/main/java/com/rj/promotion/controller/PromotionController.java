package com.rj.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rj.promotion.iservices.IPromotionService;
import com.rj.promotion.models.ProductQuantity;



@Controller
public class PromotionController {
	
	@Autowired
	IPromotionService promotionService;

	@PostMapping(value="/promotion/calculate")
	public ResponseEntity<Integer> updateProject(@RequestBody ProductQuantity pq) {
		return ResponseEntity.status(HttpStatus.OK).body(promotionService.calculatePriceOfProducts(pq));
	}
}
