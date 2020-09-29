package com.rj.promotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rj.promotion.controller.PromotionController;
import com.rj.promotion.models.ProductQuantity;

@SpringBootTest
class PromotionApplicationTests {

	@Autowired
	PromotionController promotionController;
	
	@Test
	public void getPlanControllerTestScenario1() {
		ProductQuantity pq = new ProductQuantity();
		pq.setProductQuantityA(1);
		pq.setProductQuantityB(1);
		pq.setProductQuantityC(1);
		
		ResponseEntity<Integer> priceCalculated = promotionController.calculatePrice(pq);
		assertEquals(HttpStatus.OK, priceCalculated.getStatusCode());
		assertEquals(100, priceCalculated.getBody().intValue());
	}
	
	@Test
	public void getPlanControllerTestScenario2() {
		ProductQuantity pq = new ProductQuantity();
		pq.setProductQuantityA(5);
		pq.setProductQuantityB(5);
		pq.setProductQuantityC(1);
		
		ResponseEntity<Integer> priceCalculated = promotionController.calculatePrice(pq);
		assertEquals(HttpStatus.OK, priceCalculated.getStatusCode());
		assertEquals(370, priceCalculated.getBody().intValue());
	}
	
	@Test
	public void getPlanControllerTestScenario3() {
		ProductQuantity pq = new ProductQuantity();
		pq.setProductQuantityA(3);
		pq.setProductQuantityB(5);
		pq.setProductQuantityC(1);
		pq.setProductQuantityD(1);
		
		ResponseEntity<Integer> priceCalculated = promotionController.calculatePrice(pq);
		assertEquals(HttpStatus.OK, priceCalculated.getStatusCode());
		assertEquals(280, priceCalculated.getBody().intValue());
	}
	
	@Test
	public void getPlanControllerTestScenario4() {
		ProductQuantity pq = new ProductQuantity();
		pq.setProductQuantityA(3);
		pq.setProductQuantityB(4);
		pq.setProductQuantityC(2);
		pq.setProductQuantityD(2);
		
		ResponseEntity<Integer> priceCalculated = promotionController.calculatePrice(pq);
		assertEquals(HttpStatus.OK, priceCalculated.getStatusCode());
		assertEquals(280, priceCalculated.getBody().intValue());
	}
	
	@Test
	public void getPlanControllerTestScenario5() {
		ProductQuantity pq = new ProductQuantity();
		pq.setProductQuantityA(3);
		pq.setProductQuantityB(2);
		pq.setProductQuantityC(2);
		pq.setProductQuantityD(4);
		
		ResponseEntity<Integer> priceCalculated = promotionController.calculatePrice(pq);
		assertEquals(HttpStatus.OK, priceCalculated.getStatusCode());
		assertEquals(265, priceCalculated.getBody().intValue());
	}
	
	

}
