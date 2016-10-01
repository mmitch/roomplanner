/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.RectangularRoom;
import de.cgarbs.roomplanner.room.Room;
import de.cgarbs.roomplanner.room.additional.CornerInset;

public class RoomPlanner {

	public static void main(String[] args) {
		
		Length length = Length.of("3.39 m");
		Length width = Length.of("3.83 m");
		Length height = Length.of("2.40 m");

		Length cornerLength = Length.of("60 cm");
		Length cornerWidth = Length.of("50 cm");

		System.out.println("given a basic room of " + length + " x " + width
				+ " with a ceiling height of " + height);

		Room room = new RectangularRoom(length, width, height);

		printRoom(room);

		System.out.println("adding a corner inset of " + cornerLength + " x " + cornerWidth);

		CornerInset inset = new CornerInset(cornerLength, cornerWidth);
		room = room.add(inset);

		printRoom(room);
	}

	private static void printRoom(Room room) {
		System.out.println();
		System.out.println("  the floor   area is " + room.getFloor());
		System.out.println("  the wall    area is " + room.getWall());
		System.out.println("  the ceiling area is " + room.getCeiling());
		System.out.println();
	}
	
}
