/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import java.math.BigDecimal;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.area.AreaUnit;

public class M2 extends Area {

	public M2(String value) {
		super(new BigDecimal(value), AreaUnit.M2);
	}

}
