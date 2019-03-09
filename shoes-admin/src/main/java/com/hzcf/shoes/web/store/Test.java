package com.hzcf.shoes.web.store;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		BigDecimal yhje = new BigDecimal(0);
  		yhje = new BigDecimal("3381.0000").subtract(new BigDecimal(String.valueOf("2391.0000")));
  		System.out.println(yhje);
	}
}
