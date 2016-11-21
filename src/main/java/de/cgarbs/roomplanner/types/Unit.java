/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.types;

import java.math.BigDecimal;

public interface Unit
{
	String forDisplay();

	BigDecimal getBaseFactor();
}
