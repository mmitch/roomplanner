/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class SlopedWallTest {

	private SlopedWall slope = new SlopedWall(WallPosition.EAST, new CM(9), new CM(12));
	
	@Test
	public void slopedWallDoesNotChangeFloorArea() {
		Floor floor = new Floor(new CM(2), new CM(3));
		slope.extendFloor(floor);
		assertThat(floor.getArea(), is(new CM2(6)));
	}

	@Test
	public void slopedEastWallReducesCeilingAreaByNorthSouthWallLengthTimesDepth() {
		Ceiling ceiling = new Ceiling(new CM(10), new CM(20));
		slope.extendCeiling(ceiling);
		assertThat(ceiling.getArea(), is(new CM2(200 - 10*12)));
	}

	@Test
	public void slopedEastWallIncreasesWallByComplicatedThinie() {
		fail("FIXME: test for wall extension - not implemented");
	}
	
	// FIXME: tests for different wall directions (test an internal method?)
}
