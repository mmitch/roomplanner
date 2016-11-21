/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class BoxRoomTest
{

	@Test
	public void floorAreaOfABoxRoomIsWidthTimesLength()
	{
		BoxRoom testRoom = new BoxRoom(new CM(10), new CM(20), new CM(30));
		assertThat(testRoom.getFloorArea(), is(new CM2(200)));
	}

	@Test
	public void ceilingAreaOfABoxRoomIsWidthTimesLength()
	{
		BoxRoom testRoom = new BoxRoom(new CM(10), new CM(20), new CM(30));
		assertThat(testRoom.getCeilingArea(), is(new CM2(200)));
	}

	@Test
	public void wallAreaOfABoxRoomIsHeightMultipliedByTwoMultipliedByLengthPlusWidth()
	{
		BoxRoom testRoom = new BoxRoom(new CM(10), new CM(20), new CM(30));
		// Northern Wall/Southern wall: 10 * 30 each
		// West Wall/East Wall: 20 * 30 each
		// total: 300 + 300 + 600 + 600 = 1800
		assertThat(testRoom.getWallArea(), is(new CM2(1800)));
	}

	@Test
	public void southWallStartsAtOrigin()
	{
		Wall wall = new BoxRoom(new CM(10), new CM(20), new CM(30)).walls.get(WallPosition.SOUTH);
		assertThat(wall.getOffset(), is(Position.ORIGIN));
	}

	@Test
	public void westWallStartsAtOrigin()
	{
		Wall wall = new BoxRoom(new CM(10), new CM(20), new CM(30)).walls.get(WallPosition.WEST);
		assertThat(wall.getOffset(), is(Position.ORIGIN));
	}

	@Test
	public void northWallStartsAtNorthEndOfWestWall()
	{
		Wall wall = new BoxRoom(new CM(10), new CM(20), new CM(30)).walls.get(WallPosition.NORTH);
		assertThat(wall.getOffset(), is(new Position(new CM(10), Length.ZERO)));
	}

	@Test
	public void eastWallStartsAtEastEndOfSouthWall()
	{
		Wall wall = new BoxRoom(new CM(10), new CM(20), new CM(30)).walls.get(WallPosition.EAST);
		assertThat(wall.getOffset(), is(new Position(Length.ZERO, new CM(20))));
	}
}
