/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape.extension;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.shape.Shape;

public class Extension implements Shape {

	Area area;
	
	public Extension(Shape shape) {
		this(shape.getArea());
	}

	public Extension(Area area) {
		this.area = area;
	}

	@Override
	public Area getArea() {
		return area;
	}
	
}
