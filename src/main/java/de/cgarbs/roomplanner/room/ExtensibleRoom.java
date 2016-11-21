/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.stream.Stream;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.extension.Extension;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.wavefront.Face;

public class ExtensibleRoom implements Room
{

	private Floor floor;
	private Ceiling ceiling;
	Walls walls;

	public ExtensibleRoom(Floor floor, Ceiling ceiling, Walls walls)
	{
		this.floor = floor;
		this.ceiling = ceiling;
		this.walls = walls;
	}

	@Override
	public Area getFloorArea()
	{
		return floor.getArea();
	}

	@Override
	public Area getCeilingArea()
	{
		return ceiling.getArea();
	}

	@Override
	public Area getWallArea()
	{
		return walls.getArea();
	}

	@Override
	public Stream<Face> faces()
	{
		// no inlining: compiler breaks without the HasFaces type hint!
		// Stream<Face> stream = Stream.of(floor,
		// walls).flatMap(HasFaces::faces);
		// return stream;
		Stream<HasFaces> stream = Stream.of(floor, walls);
		return stream.flatMap(HasFaces::faces);
	}

	public ExtensibleRoom add(Extension extension)
	{
		extension.extendFloor(floor);
		extension.extendCeiling(ceiling);
		extension.extendWalls(walls);
		return this;
	}

}