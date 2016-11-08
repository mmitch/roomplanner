/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.length;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;
import de.cgarbs.roomplanner.test.stub.M;

public class LengthTest
{

	@Test
	public void multiplyingALengthWithALengthGivesAnArea()
	{
		assertThat(new CM(2).multiplyWith(new CM(2)), is(new CM2(4)));
	}

	@Test
	public void multiplicationWithDifferentUnitsGetsConvertedToTheFirstUnitSquared()
	{
		assertThat(new CM(2).multiplyWith(new M(1)), is(new CM2(200)));
	}

	@Test
	public void spaceSeparatedStringCanBeParsedAsLength()
	{
		assertThat(Length.of("12 cm"), is(new CM(12)));
	}

	@Test
	public void addingTwoLengthGivesTheSumOfTheLengths()
	{
		assertThat(new CM(1).add(new CM(1)), is(new CM(2)));
	}

	@Test
	public void differentUnitsCanBeSummed()
	{
		assertThat(new CM(10).add(new M("0.1")), is(new CM(20)));
	}

	@Test
	public void negateChangesValueSignum()
	{
		Length length = new Length(1, LengthUnit.M);
		Length negated = length.negate();
		assertThat(negated.getValue(), is(length.getValue().negate()));
		assertThat(negated.getUnit(), is(length.getUnit()));
	}
}
