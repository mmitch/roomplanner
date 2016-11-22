/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.M;

public class WallsTest
{
	@Test
	public void wallsFacesAreFacesOfTheIndividualWallsConcatinated()
	{
		Wall wall1 = new Wall(WallPosition.NORTH, new CM(3), new CM(12), new Position(new M(2), new M(4)));
		Wall wall2 = new Wall(WallPosition.WEST, new M(2), new M(7), new Position(new CM(12), new CM(14)));

		Walls walls = Walls.of(wall1, wall2);

		assertThat( //
				walls.faces().collect(Collectors.toSet()),
				is( //
						Stream.of(wall1, wall2) //
								.flatMap(Wall::faces) //
								.collect(Collectors.toSet())));
	}
}
