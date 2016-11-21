/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.stream.Stream;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;

public class BoxRoom extends ExtensibleRoom
{

	public BoxRoom(Length northSouth, Length eastWest, Length height)
	{
		super( //
				createFloor(northSouth, eastWest), //
				createCeiling(northSouth, eastWest), //
				createWalls(northSouth, eastWest, height) //
		);
	}

	private static Floor createFloor(Length northSouth, Length eastWest)
	{
		return new Floor(northSouth, eastWest);
	}

	private static Ceiling createCeiling(Length northSouth, Length eastWest)
	{
		return new Ceiling(northSouth, eastWest);
	}

	private static Walls createWalls(Length northSouth, Length eastWest, Length height)
	{
		Walls walls = new Walls();
		Stream.of(WallPosition.values()) //
				.map((position) -> createWall(position, northSouth, eastWest, height)) //
				.forEach(walls::put);
		return walls;
	}

	private static Wall createWall(WallPosition position, Length northSouth, Length eastWest, Length height)
	{
		return new Wall( //
				position, //
				getLength(position, northSouth, eastWest), //
				height, //
				getOffset(position, northSouth, eastWest) //
		);

	}

	private static Length getLength(WallPosition position, Length northSouth, Length eastWest)
	{
		switch (position)
		{
			case EAST:
			case WEST:
				return northSouth;
			case NORTH:
			case SOUTH:
				return eastWest;
		}
		return null; // unreachable code
	}

	private static Position getOffset(WallPosition position, Length northSouth, Length eastWest)
	{
		switch (position)
		{
			case NORTH:
				return new Position(northSouth, Length.ZERO);
			case EAST:
				return new Position(Length.ZERO, eastWest);
			case SOUTH:
			case WEST:
				return new Position(Length.ZERO, Length.ZERO);
		}
		return null; // unreachable code
	}

}
