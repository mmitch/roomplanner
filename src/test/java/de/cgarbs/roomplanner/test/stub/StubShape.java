/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.shape.Shape;

public class StubShape implements Shape {

	private Area area;

	public StubShape(Area area) {
		this.area = area;
	}

	@Override
	public Area getArea() {
		return area;
	}

}