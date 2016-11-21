/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.pos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.M;

public class PositionTest
{
	@Test
	public void originIsNotEqualToZero()
	{
		assertThat(Position.ORIGIN.equals(null), is(false));
	}

	@Test
	public void differentTypesAreNotEqual()
	{
		assertThat(Position.ORIGIN, not("some string"));
	}

	@Test
	public void sameCoordinatesAreEqual()
	{
		assertThat(new Position(Length.ZERO, Length.ZERO), is(Position.ORIGIN));
	}

	@Test
	public void differentNorthSouthCoordinatesAreNotEqual()
	{
		assertThat(new Position(new CM(2), new CM(2)), not(new Position(new CM(3), new CM(2))));
	}

	@Test
	public void differentEastWestCoordinatesAreNotEqual()
	{
		assertThat(new Position(new M(2), new M(2)), not(new Position(new M(2), new M(3))));

	}
}
