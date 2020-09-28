package com.rj.promotion.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantity {

	@JsonProperty("A")
	private int productQuantityA;
	@JsonProperty("B")
	private int productQuantityB;
	@JsonProperty("C")
	private int productQuantityC;
	@JsonProperty("D")
	private int productQuantityD;
	
	public int getConditionalProductQuantity(String product) {
		switch(product) {
		case "A" : return this.productQuantityA;
		case "B" : return this.productQuantityB;
		case "C" : return this.productQuantityC;
		case "D" : return this.productQuantityD;
		default : return 0;
		
		}
	}
}
