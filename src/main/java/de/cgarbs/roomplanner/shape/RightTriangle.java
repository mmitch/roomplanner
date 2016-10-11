/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.length.LengthUnit;
import de.cgarbs.roomplanner.math.Math;

public class RightTriangle extends Shape {

	private Length b;
	private Length a;

	public RightTriangle(Length a, Length b) {
		super(new Rectangle(a, b).getArea().divideBy(new BigDecimal(2)));
		this.a = a;
		this.b = b;
	}
	
	public Length getC() {
		LengthUnit unit = a.getUnit();
		BigDecimal aSquared = a.getValue().pow(2);
		BigDecimal bSquared = b.convertTo(unit).getValue().pow(2);
		return new Length(
				Math.sqrt(aSquared.add(bSquared)),
				unit
				);
	}

}
