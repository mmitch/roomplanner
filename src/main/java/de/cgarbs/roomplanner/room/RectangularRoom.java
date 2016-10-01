/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;

public class RectangularRoom implements BaseRoom {
	
	private Length northSouth;
	private Length eastWest;
	private Length height;

	public RectangularRoom(Length northSouth, Length eastWest, Length height) {
		this.northSouth = northSouth;
		this.eastWest = eastWest;
		this.height = height;
	}

	@Override
	public Area getFloor() {
		return Area.of(new Rectangle(northSouth, eastWest));
	}

	@Override
	public Area getCeiling() {
		return Area.of(new Rectangle(northSouth, eastWest));
	}

	@Override
	public Area getWall() {
		return Area.of(
				new Rectangle(northSouth, height),
				new Rectangle(northSouth, height),
				new Rectangle(eastWest, height),
				new Rectangle(eastWest, height)
				);
	}
	
}
