/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.math;

import java.math.BigDecimal;

import org.jscience.mathematics.number.Real;

public interface Math
{

	static BigDecimal sqrt(BigDecimal number)
	{
		Real realNumber = Real.valueOf(number.toString());
		Real sqrt = realNumber.sqrt();
		return new BigDecimal(sqrt.toString());
	}

}
