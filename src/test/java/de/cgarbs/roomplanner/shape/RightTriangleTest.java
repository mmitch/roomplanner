/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class RightTriangleTest {

	@Test
	public void theAreaOfARightTriangleIsWidthMupltipliedByHeightDividedByTwo() {
		assertThat(new RightTriangle(new CM(4), new CM(5)).getArea(), is(new CM2(10)));
	}
	
	@Test
	public void nineSquaredPlusTwelveSquaredEqualsFifteenSquared() {
		assertThat(new RightTriangle(new CM(9), new CM(12)).getC(), is(new CM(15)));
	}

}
