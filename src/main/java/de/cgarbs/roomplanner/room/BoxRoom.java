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
import de.cgarbs.roomplanner.room.wall.Walls;

public class BoxRoom extends ExtensibleRoom {

	public BoxRoom(Length northSouth, Length eastWest, Length height) {
		super(
				createFloor(northSouth, eastWest),
				createCeiling(northSouth, eastWest),
				createWalls(northSouth, eastWest, height)
				);
	}

	private static Floor createFloor(Length northSouth, Length eastWest) {
		return new Floor(northSouth, eastWest);
	}

	private static Ceiling createCeiling(Length northSouth, Length eastWest) {
		return new Ceiling(northSouth, eastWest);
	}

	private static Walls createWalls(Length northSouth, Length eastWest, Length height) {
		Walls walls = new Walls();
		walls.put(WallPosition.NORTH, new Wall(eastWest, height));
		walls.put(WallPosition.EAST, new Wall(northSouth, height));
		walls.put(WallPosition.SOUTH, new Wall(eastWest, height));
		walls.put(WallPosition.WEST, new Wall(northSouth, height));
		return walls;
	}

}
