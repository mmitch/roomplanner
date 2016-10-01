/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class RectangleTest {

	@Test
	public void theAreaOfARectangleIsWidthMupltipliedByHeight() {
		assertThat(new Rectangle(new CM(2), new CM(3)).getArea(), is(new CM2(6)));
	}
}
