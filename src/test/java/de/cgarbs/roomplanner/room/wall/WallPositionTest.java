/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class WallPositionTest {

	@Test
	public void wallAdjacentClockwiseToEastIsSouth() {
		assertThat(WallPosition.EAST.getNextClockwise(), is(WallPosition.SOUTH));
	}
	
	@Test
	public void wallAdjacentCounterClockwiseToWestIsSouth() {
		assertThat(WallPosition.WEST.getNextCounterClockwise(), is(WallPosition.SOUTH));
	}
	
	@Test
	public void wallsAdjacentToNorthWallAreEastWallAndWestWall() {
		Collection<WallPosition> result = WallPosition.NORTH.getAdjacentWalls();
		assertThat(result.size(), is(2));
		assertThat(result, CoreMatchers.hasItems(WallPosition.EAST, WallPosition.WEST));
	}
	
}
