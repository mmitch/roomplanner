/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.Iterator;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.extension.Extension;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.Walls;

public class ExtensibleRoom implements Room {

	private Floor floor;
	private Ceiling ceiling;
	private Walls walls;

	public ExtensibleRoom(Floor floor, Ceiling ceiling, Walls walls) {
		this.floor = floor;
		this.ceiling = ceiling;
		this.walls = walls;
	}

	@Override
	public Area getFloorArea() {
		return floor.getArea();
	}

	@Override
	public Area getCeilingArea() {
		return ceiling.getArea();
	}

	@Override
	public Area getWallArea() {
		Iterator<Wall> iter = walls.values().iterator();
		Area area = iter.next().getArea();
		while (iter.hasNext()) {
			area = area.add(iter.next().getArea());
		}
		return area;
	}

	public ExtensibleRoom add(Extension extension) {
		extension.extendFloor(floor);
		extension.extendCeiling(ceiling);
		extension.extendWalls(walls);
		return this;
	}
}