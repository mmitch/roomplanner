/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.length.LengthUnit;

public class M extends Length {

	public M(int value) {
		super(value, LengthUnit.M);
	}

}
