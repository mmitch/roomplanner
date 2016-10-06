/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.Iterator;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.shape.extension.Extender;

public class BoxRoom implements Room {

	Floor floor;
	Ceiling ceiling;

	Walls walls = new Walls();

	public BoxRoom(Length northSouth, Length eastWest, Length height) {
		addFloor(northSouth, eastWest);
		addCeiling(northSouth, eastWest);

		addWalls(northSouth, eastWest, height);
	}

	@Override
	public Area getFloor() {
		return floor.getArea();
	}

	@Override
	public Area getCeiling() {
		return ceiling.getArea();
	}

	@Override
	public Area getWall() {
		Iterator<Wall> iter = walls.values().iterator();
		Area area = iter.next().getArea();
		while (iter.hasNext()) {
			area = area.add(iter.next().getArea());
		}
		return area;
	}
	
	public BoxRoom setCornerInset(CornerPosition corner, Extender inset) {
		inset.extendFloor(floor);
		inset.extendCeiling(ceiling);
		inset.extendWalls(walls, corner);
		return this;
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
