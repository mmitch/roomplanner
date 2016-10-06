/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;

public class BoxRoom extends ExtensibleRoom {

	public BoxRoom(Length northSouth, Length eastWest, Length height) {
		addFloor(northSouth, eastWest);
		addCeiling(northSouth, eastWest);

		addWalls(northSouth, eastWest, height);
	}

	private void addFloor(Length northSouth, Length eastWest) {
		floor = new Floor(northSouth, eastWest);
	}

	private void addCeiling(Length northSouth, Length eastWest) {
		ceiling = new Ceiling(northSouth, eastWest);
	}

	private void addWalls(Length northSouth, Length eastWest, Length height) {
		walls.put(WallPosition.NORTH, new Wall(eastWest, height));
		walls.put(WallPosition.EAST, new Wall(northSouth, height));
		walls.put(WallPosition.SOUTH, new Wall(eastWest, height));
		walls.put(WallPosition.WEST, new Wall(northSouth, height));
	}

}
