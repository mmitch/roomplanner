/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.shape.Shape;
import de.cgarbs.roomplanner.shape.Shapes;

public class Extensible {

	Shapes extensions = new Shapes();
	Shape baseShape;
	
	public Extensible(Shape baseShape) {
		this.baseShape = baseShape;
	}

	public Area getArea() {
		Area area = baseShape.getArea();
		for (Shape extension: extensions) {
			area = area.add(extension.getArea());
		}
		return area;
	}

	public Extensible add(Shape extension) {
		extensions.add(extension);
		return this;
	}
}
