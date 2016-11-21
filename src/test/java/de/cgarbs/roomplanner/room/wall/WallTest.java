/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.stream.Collectors;

import org.junit.Test;

import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.test.stub.M;
import de.cgarbs.wavefront.Face;
import de.cgarbs.wavefront.V;

public class WallTest
{
	@Test
	public void faceOfAWallIsCalculatedCorrectly()
	{
		Wall wall = new Wall(WallPosition.EAST, new M(4), new M(2), new Position(new M(1), new M(2)));

		Face expected = new Face( //
				new V(m(2), m(1), m(0)), //
				new V(m(2), m(1), m(2)), //
				new V(m(2), m(5), m(2)), //
				new V(m(2), m(5), m(0)) //
		);

		assertThat( //
				wall.faces().collect(Collectors.toList()), //
				is(Collections.singletonList(expected)));
	}

	private static double m(int length)
	{
		return new M(length).getInBaseUnit().doubleValue();
	}
}
