/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.corner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.wall.WallPosition;

public class CornerPositionTest {

	@Test
	public void wallsAdjacentToNorthEastCornerAreNorthAndEast() {
		Collection<WallPosition> result = CornerPosition.NORTHEAST.getAdjacentWalls();
		assertThat(result.size(), is(2));
		assertThat(result, CoreMatchers.hasItems(WallPosition.NORTH, WallPosition.EAST));
	}
	
}
