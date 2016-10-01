/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.BaseRoom;
import de.cgarbs.roomplanner.room.RectangularRoom;

public class RoomPlanner {

	public static void main(String[] args) {
		
		Length length = Length.of("3.39 m");
		Length width = Length.of("3.83 m");
		Length height = Length.of("2.40 m");
		
		System.out.println("given a basic room of " + length + " x " + width
				+ " with a ceiling height of " + height);
		
		BaseRoom room = new RectangularRoom(length, width, height);
		
		System.out.println("  the floor   area is " + room.getFloor());
		System.out.println("  the wall    area is " + room.getWall());
		System.out.println("  the ceiling area is " + room.getCeiling());
	}
	
}
