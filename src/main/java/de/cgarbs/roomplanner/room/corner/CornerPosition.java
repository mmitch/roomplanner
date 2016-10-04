/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.corner;

import java.util.Arrays;
import java.util.List;

import de.cgarbs.roomplanner.room.wall.WallPosition;

public enum CornerPosition {
	NORTHEAST(WallPosition.NORTH),
	SOUTHEAST(WallPosition.EAST),
	SOUTHWEST(WallPosition.SOUTH),
	NORTHWEST(WallPosition.WEST);

	private WallPosition firstWall;

	private CornerPosition(WallPosition firstWall) {
		this.firstWall = firstWall;
	}

	public List<WallPosition> getAdjacentWalls() {
		return Arrays.asList(
				firstWall,
				firstWall.getNextClockwise()
				);
	}
}