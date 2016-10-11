/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import de.cgarbs.roomplanner.area.Area;

public class Shape {
	
	private Area area;

	protected Shape(Area area) {
		this.area = area;
	}

	public Area getArea() {
		return area;
	}
	
	public Shape negate() {
		return new Shape(area.negate());
	}
	
}
