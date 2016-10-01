/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.room.Room;

public class StubRoom extends Room {

	private Area floor;
	private Area wall;
	private Area ceiling;

	public StubRoom(Area floor, Area wall, Area ceiling) {
		this.floor = floor;
		this.wall = wall;
		this.ceiling = ceiling;
		
	}
	
	@Override
	public Area getFloor() {
		return floor;
	}

	@Override
	public Area getWall() {
		return wall;
	}

	@Override
	public Area getCeiling() {
		return ceiling;
	}

}
