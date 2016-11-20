/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.types;

import java.math.BigDecimal;

public class ScalarWithUnit<U extends Unit>
{

	private BigDecimal value;
	private U unit;

	public ScalarWithUnit(BigDecimal value, U unit)
	{
		this.value = value;
		this.unit = unit;
	}

	public ScalarWithUnit(long value, U unit)
	{
		this(new BigDecimal(value), unit);
	}

	public String forDisplay()
	{
		return value.stripTrailingZeros().toPlainString() + unit.forDisplay();
	}

	public BigDecimal getValue()
	{
		return value;
	}

	public U getUnit()
	{
		return unit;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof ScalarWithUnit))
		{
			return false;
		}
		ScalarWithUnit<?> other = (ScalarWithUnit<?>) obj;
		return forDisplay().equals(other.forDisplay());
	}

	@Override
	public String toString()
	{
		return forDisplay();
	}

	public ScalarWithUnit<U> convertTo(U targetUnit)
	{
		if (this.unit == targetUnit)
		{
			return this;
		}
		BigDecimal targetBaseFactor = targetUnit.getBaseFactor();
		BigDecimal targetValue = convertToBaseFactor(targetBaseFactor);
		return new ScalarWithUnit<U>(targetValue, targetUnit);
	}

	public BigDecimal getInBaseUnit()
	{
		return convertToBaseFactor(BigDecimal.ONE);
	}

	private BigDecimal convertToBaseFactor(BigDecimal targetBaseFactor)
	{
		BigDecimal sourceBaseFactor = this.unit.getBaseFactor();
		return value.divide(targetBaseFactor).multiply(sourceBaseFactor);
	}

}
