/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape.extension;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.shape.Shape;

public class Extensible {

	Extensions extensions = new Extensions();
	Shape baseShape;
	
	public Extensible(Shape baseShape) {
		this.baseShape = baseShape;
	}

	public Area getArea() {
		Area area = baseShape.getArea();
		for (Extension extension: extensions) {
			area = area.add(extension.getArea());
		}
		return area;
	}

	public Extensible add(Extension extension) {
		extensions.add(extension);
		return this;
	}
}
