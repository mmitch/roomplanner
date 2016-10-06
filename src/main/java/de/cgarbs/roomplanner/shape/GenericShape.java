/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import de.cgarbs.roomplanner.area.Area;

public class GenericShape implements Shape {

	Area area;
	
	public GenericShape(Shape shape) {
		this(shape.getArea());
	}

	public GenericShape(Area area) {
		this.area = area;
	}

	@Override
	public Area getArea() {
		return area;
	}
	
}
