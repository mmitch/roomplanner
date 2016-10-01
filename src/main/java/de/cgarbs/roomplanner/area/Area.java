/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.area;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.shape.Shape;
import de.cgarbs.roomplanner.types.ScalarWithUnit;

public class Area extends ScalarWithUnit<AreaUnit> {
	
	public Area(BigDecimal value, AreaUnit unit) {
		super(value, unit);
	}
	
	protected Area(long value, AreaUnit unit) {
		super(value, unit);
	}
	
	public static Area of(Shape firstShape, Shape... moreShapes) {
		Area area = firstShape.getArea();
		for (Shape shape: moreShapes) {
			area = area.add(shape.getArea());
		}
		return area;
	}

	public Area add(Area otherArea) {
		return new Area(
				this.getValue().add(otherArea.convertTo(getUnit()).getValue()),
				getUnit()
				);
	}
	
}
