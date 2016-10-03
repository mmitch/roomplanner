/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import java.util.Arrays;
import java.util.Collection;

public enum WallPosition {
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);

	private int position;

	private WallPosition(int position) {
		this.position = position;
	}

	private static WallPosition get(int position) {
		for (WallPosition value: values()) {
			if (value.position == position) {
				return value;
			}
		}
		return null;
	}

	public Collection<WallPosition> getAdjacentWalls() {
		return Arrays.asList(
				getNextCounterClockwise(),
				getNextClockwise()
				);
	}

	public WallPosition getNextClockwise() {
		int count = values().length;
		return get((position + 1) % count);
	}

	public WallPosition getNextCounterClockwise() {
		int count = values().length;
		return get((position - 1 + count) % count);
	}
}