/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.length;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.types.ScalarWithUnit;

public class Length extends ScalarWithUnit<LengthUnit> {
	
	protected Length(long value, LengthUnit unit) {
		super(value, unit);
	}

	public Length(BigDecimal value, LengthUnit unit) {
		super(value, unit);
	}

	public Area multiplyWith(Length otherLength) {
		return new Area( 
				this.getValue().multiply(otherLength.convertTo(getUnit()).getValue()),
				this.getUnit().getSquaredUnit()
				);
	}

	public static Length of(String string) {
		String value = "0";
		String unit = "";
		
		String[] parts = string.split("\\s+");
		if (parts.length > 0) {
			value = parts[0];
		}
		if (parts.length > 1) {
			unit = parts[1];
		}

		return new Length(new BigDecimal(value), LengthUnit.of(unit));
	}
	
}
