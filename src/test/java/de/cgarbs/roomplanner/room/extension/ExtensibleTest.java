/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.RightTriangle;
import de.cgarbs.roomplanner.shape.Shape;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class ExtensibleTest {

	@Test
	public void plainExtensibleHasAreaOfBaseShape()
	{
		Shape baseShape = new RightTriangle(new CM(2), new CM(3)); 
		assertThat(new Extensible(baseShape).getArea(), is(baseShape.getArea()));
	}
	
	@Test
	public void extensionAreaIsAddedToBaseShapeArea()
	{
		Shape baseShape = new Rectangle(new CM(3), new CM(3)); 
		Shape extension = new Rectangle(new CM(2), new CM(2));
		assertThat(new Extensible(baseShape).add(extension).getArea(), is(new CM2(13)));
	}
	
}
