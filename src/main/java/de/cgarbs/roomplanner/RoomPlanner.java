/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.BoxRoom;
import de.cgarbs.roomplanner.room.ExtensibleRoom;
import de.cgarbs.roomplanner.room.Room;
import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.extension.CornerInset;
import de.cgarbs.roomplanner.room.extension.Extension;
import de.cgarbs.wavefront.Obj;

public class RoomPlanner
{

	public static void main(String[] args) throws IOException
	{

		Length length = Length.of("3.39 m");
		Length width = Length.of("3.83 m");
		Length height = Length.of("2.40 m");

		Length cornerLength = Length.of("60 cm");
		Length cornerWidth = Length.of("50 cm");

		System.out.println("given a basic room of " + length + " x " + width + " with a ceiling height of " + height);

		ExtensibleRoom room = new BoxRoom(length, width, height);

		printRoom(room);

		System.out.println("adding a corner inset of " + cornerLength + " x " + cornerWidth);

		Extension inset = new CornerInset(CornerPosition.NORTHWEST, cornerLength, cornerWidth);
		room = room.add(inset);

		printRoom(room);

		exportObjFile(room);
	}

	private static void printRoom(Room room)
	{
		System.out.println();
		System.out.println("  the floor   area is " + room.getFloorArea());
		System.out.println("  the wall    area is " + room.getWallArea());
		System.out.println("  the ceiling area is " + room.getCeilingArea());
		System.out.println();
	}

	private static void exportObjFile(Room room) throws IOException
	{
		File tempFile = File.createTempFile("RoomPlanner", ".obj");
		Obj obj = new Obj();
		room.faces().forEach(obj::addFace);
		obj.writeTo(new FileOutputStream(tempFile));
		System.out.println("  .obj file written to: " + tempFile.getAbsolutePath());
	}

}
