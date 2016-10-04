/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.math;

import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class MathTest {
	
	@Test
	public void squareRootOfFourIsTwo() {
		assertThat(Math.sqrt(new BigDecimal(4)), closeTo(new BigDecimal("2"), BigDecimal.ZERO));
	}

	@Test
	public void squareRootOfTwoIsOnePointSomething() {
		assertThat(Math.sqrt(new BigDecimal(2)), closeTo(new BigDecimal("1.4142"), new BigDecimal("0.00005")));
	}

}
