/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class CornerInsetTest {

	private CornerInset inset = new CornerInset(CornerPosition.NORTHEAST, new CM(2), new CM(3));
	
	@Test
	public void cornerInsetReducesFloorByCutoutArea() {
		Floor floor = new Floor(new CM(4), new CM(5));

		inset.extendFloor(floor);

		assertThat(floor.getArea(), is(new CM2(4*5 - 2*3)));
	}
	
	@Test
	public void cornerInsetReducesCeilingByCutoutArea() {
		Ceiling ceiling = new Ceiling(new CM(4), new CM(5));

		inset.extendCeiling(ceiling);

		assertThat(ceiling.getArea(), is(new CM2(4*5 - 2*3)));
	}

	@Test
	public void cornerInsetExtendsOnlyAdjacentWalls() {
		Walls walls = createWalls();
		
		inset.extendWalls(walls);
		
		assertThat(walls.get(WallPosition.NORTH).isExtended(), is(true));
		assertThat(walls.get(WallPosition.EAST).isExtended(), is(true));
		
		assertThat(walls.get(WallPosition.SOUTH).isExtended(), is(false));
		assertThat(walls.get(WallPosition.WEST).isExtended(), is(false));
	}
	
	@Test
	public void cornerInsetDoesNotChangeWallAreas() {
		Walls walls = createWalls();
		
		inset.extendWalls(walls);
		
		for (Wall wall: walls.values()) {
			assertThat(wall.getArea(), is(new CM2(20)));
		}
	}

	private Walls createWalls() {
		Walls walls = new Walls();
		for (WallPosition wallPosition : WallPosition.values()) {
			walls.put(wallPosition, new Wall(new CM(4), new CM(5)));
		}
		return walls;
	}

	
}
