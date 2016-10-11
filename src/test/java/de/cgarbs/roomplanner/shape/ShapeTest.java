/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.test.stub.CM2;

public class ShapeTest {

	@Test
	public void negatedShapeReturnsNegatedArea() {
		Area area = new CM2(2);
		Shape negatedShape = new Shape(area).negate();
		assertThat(negatedShape.getArea(), is(area.negate()));
	}
}
