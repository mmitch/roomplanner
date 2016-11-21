/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.RightTriangle;

public class SlopedWall implements Extension
{

	private WallPosition wall;
	private Length heightOffset;
	private Length depth;

	public SlopedWall(WallPosition wall, Length heightOffset, Length depth)
	{
		this.wall = wall;
		this.heightOffset = heightOffset;
		this.depth = depth;
	}

	@Override
	public void extendFloor(Floor floor)
	{
		// floor remains unchanged
	}

	@Override
	public void extendCeiling(Ceiling ceiling)
	{
		ceiling.add(new Rectangle(getWallLength(ceiling), depth).negate());
	}

	@Override
	public void extendWalls(Walls walls)
	{
		// shrink adjacent walls
		wall.getAdjacentWalls().stream() //
				.map((pos) -> walls.get(pos)) //
				.forEach((wall) -> {
					Length slopeHeight = wall.getHeight().add(heightOffset.negate());
					RightTriangle triangle = new RightTriangle(slopeHeight, depth);
					wall.add(triangle.negate());
				});

		// expand slope wall
		Wall slopeWall = walls.get(wall);
		Length slopeHeight = slopeWall.getHeight().add(heightOffset.negate());
		RightTriangle triangle = new RightTriangle(slopeHeight, depth);
		Length extraHeight = triangle.getC().add(slopeHeight.negate());
		slopeWall.add(new Rectangle(extraHeight, slopeWall.getLength()));
	}

	private Length getWallLength(Ceiling ceiling)
	{
		switch (wall)
		{
			case EAST:
			case WEST:
				return ceiling.getNorthSouthLength();
			case NORTH:
			case SOUTH:
				return ceiling.getEastWestLength();
		}
		return null; // unreachable code
	}

}
