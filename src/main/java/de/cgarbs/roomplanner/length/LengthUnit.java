/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.length;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.area.AreaUnit;
import de.cgarbs.roomplanner.types.Unit;

public enum LengthUnit implements Unit {
	
	CM("cm", 1,   AreaUnit.CM2),
	M("m",   100, AreaUnit.M2);
	
	private String symbol;
	private AreaUnit squared;
	private BigDecimal baseFactor;

	LengthUnit(String symbol, double baseFactor, AreaUnit squared) {
		this.symbol = symbol;
		this.baseFactor = new BigDecimal(baseFactor);
		this.squared = squared;
	}
	
	public AreaUnit getSquaredUnit() {
		return squared;
	}
	
	@Override
	public String forDisplay() {
		return symbol;
	}

	@Override
	public BigDecimal getBaseFactor() {
		return baseFactor;
	}
	
	public static LengthUnit of(String unit) {
		for (LengthUnit lengthUnit: LengthUnit.values()) {
			if (lengthUnit.forDisplay().equals(unit)) {
				return lengthUnit;
			}
		}
		throw new RuntimeException("Parse Error: unknown unit: "+unit);
	}

}
