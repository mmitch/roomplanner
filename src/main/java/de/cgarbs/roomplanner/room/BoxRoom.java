/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.Iterator;
import java.util.List;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.additional.CornerInset;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.extension.Extension;

public class BoxRoom extends Room {

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
	
	public BoxRoom setCornerInset(CornerPosition corner, CornerInset inset) { // FIXME ugly, refactor!
		floor.add(new Extension(inset.getFloor()));
		ceiling.add(new Extension(inset.getCeiling()));

		List<WallPosition> adjacentWalls = corner.getAdjacentWalls();
		addWallChangesFromCornerInset(adjacentWalls.get(0), inset.getFirstWall());
		addWallChangesFromCornerInset(adjacentWalls.get(1), inset.getSecondWall());

		return this;
	}

	private void addWallChangesFromCornerInset(WallPosition wallPosition, Length length) { // FIXME ugly, refactor!
		Wall wall = walls.get(wallPosition);
		Length height = wall.getHeight();
		Area wallArea = new Rectangle(height, length).getArea();

		// this is a zero-sum change, but for bookkeeping sakes we record it
		wall.add(new Extension(wallArea.negate()));
		wall.add(new Extension(wallArea));
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
