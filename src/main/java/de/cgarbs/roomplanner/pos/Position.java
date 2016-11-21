/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.pos;

import de.cgarbs.roomplanner.length.Length;

public class Position
{
	public static final Position ORIGIN = new Position(Length.ZERO, Length.ZERO);

	private Length northSouth;
	private Length eastWest;

	public Position(Length northSouth, Length eastWest)
	{
		this.northSouth = northSouth;
		this.eastWest = eastWest;
	}

	public Length getNorthSouth()
	{
		return northSouth;
	}

	public Length getEastWest()
	{
		return eastWest;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		if (!(o instanceof Position))
		{
			return false;
		}

		Position that = (Position) o;
		return this.getNorthSouth().equals(that.getNorthSouth()) //
				&& this.getEastWest().equals(that.getEastWest());
	}
}
