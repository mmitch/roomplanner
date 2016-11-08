/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.extension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;
import de.cgarbs.roomplanner.test.stub.M;
import de.cgarbs.roomplanner.test.stub.M2;

public class SlopedWallTest
{
	@Test
	public void slopedWallDoesNotChangeFloorArea()
	{
		SlopedWall slope = new SlopedWall(WallPosition.SOUTH, new CM(2), new CM(2));
		Floor floor = new Floor(new CM(2), new CM(3));
		slope.extendFloor(floor);
		assertThat(floor.getArea(), is(new CM2(6)));
	}

	@Test
	public void slopedEastWallReducesCeilingAreaByNorthSouthWallLengthTimesDepth()
	{
		SlopedWall slope = new SlopedWall(WallPosition.EAST, new CM(9), new CM(12));
		Ceiling ceiling = new Ceiling(new CM(10), new CM(20));
		slope.extendCeiling(ceiling);
		assertThat(ceiling.getArea(), is(new CM2(200 - 10 * 12)));
	}

	@Test
	public void slopedEastWallIncreasesWallArea()
	{
		/*
		 * calculation is as follows:
		 * 1) both adjacent walls get a triangle ABC cut out with
		 * A~B = wall height - slope offset
		 * B~C = slope depth
		 * angle A<BC is a right angle, so one triangle is 1/2 * A~B * B~C
		 * and both triangles areas together are A~B * B~C to be subtracted
		 * from the wall area.
		 * 2) on the same triangle, the wall from the slope offset on upwards
		 * is slanted, A~B is smaller than A~C. Let D be on A~C so that
		 * A~D = A~B. This makes D~C the additional slanted wall height to
		 * be multiplied by the wall width.
		 * A~C = sqrt( A~B² + B~C² ) and D~C = A~C - A~B, so
		 * D~C = sqrt( A~B² + B~C² ) - A~B
		 * So add D~C * wall length to the wall area.
		 */

		Walls walls = new Walls();
		walls.put(WallPosition.SOUTH, new Wall(new M(6), new M(5)));
		walls.put(WallPosition.WEST, new Wall(new M(8), new M(5)));
		walls.put(WallPosition.NORTH, new Wall(new M(6), new M(5)));

		// wall height is 5, so an offset of 2 gives A~B = 3
		// B~C is 4 (depth)
		// this conveniently makes A~C = sqrt( 3² + 4² ) = 5 and thus D~C = 2
		SlopedWall slope = new SlopedWall(WallPosition.WEST, new M(2), new M(4));

		slope.extendWalls(walls);

		assertThat(walls.getArea(),
				is(new M2( //
						6 * 5 + 8 * 5 + 6 * 5 // initial area
								- 3 * 4 // cutouts fron adjacent walls
								+ 2 * 8 // additional slanted wall
				)));
	}
}
