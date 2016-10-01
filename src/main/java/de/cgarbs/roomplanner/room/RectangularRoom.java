/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;

public class RectangularRoom implements BaseRoom {
	
	private Length length;
	private Length width;
	private Length height;

	public RectangularRoom(Length length, Length width, Length height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	@Override
	public Area getFloor() {
		return Area.of(new Rectangle(length, width));
	}

	@Override
	public Area getCeiling() {
		return Area.of(new Rectangle(length, width));
	}

	@Override
	public Area getWall() {
		return Area.of(
				new Rectangle(length, height),
				new Rectangle(length, height),
				new Rectangle(width, height),
				new Rectangle(width, height)
				);
	}
	
}
