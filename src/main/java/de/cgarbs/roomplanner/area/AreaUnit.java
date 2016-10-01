/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.area;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.types.Unit;

public enum AreaUnit implements Unit {
	
	CM2("cm²",   1 *   1),
	M2("m²",   100 * 100);
	
	private String symbol;
	private BigDecimal baseFactor;

	AreaUnit(String symbol, double baseFactor) {
		this.symbol = symbol;
		this.baseFactor = new BigDecimal(baseFactor);
	}
	
	@Override
	public String forDisplay() {
		return symbol;
	}

	@Override
	public BigDecimal getBaseFactor() {
		return baseFactor;
	}
}
