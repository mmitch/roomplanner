/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.length.LengthUnit;

public class CM extends Length {

	public CM(int value) {
		super(value, LengthUnit.CM);
	}

}
