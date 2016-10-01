/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;

public class Rectangle implements Shape {

	private Area area;
	
	public Rectangle(Length width, Length height) {
		area = width.multiplyWith(height);
	}
	
	@Override
	public Area getArea() {
		return area;
	}

}
