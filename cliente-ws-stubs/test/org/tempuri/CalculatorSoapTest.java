package org.tempuri;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CalculatorSoapTest {

	@Test
	void testAdd() {
		CalculatorSoap calculator = new Calculator().getCalculatorSoap();
		
		int result = calculator.add(10, 2);
		System.out.println("resultado :" + result);
		Assert.assertEquals(12, result);
		
	}

}
