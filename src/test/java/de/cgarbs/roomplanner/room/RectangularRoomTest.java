/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.RectangularRoom;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class RectangularRoomTest {
	
	@Test
	public void floorAreaOfARectangularRoomIsWidthTimesLength() {
		RectangularRoom testRoom = new RectangularRoom(new CM(10), new CM(20), new CM(30));
		assertThat(testRoom.getFloor(), is(new CM2(200)));
	}

	@Test
	public void ceilingAreaOfARectangularRoomIsWidthTimesLength() {
		RectangularRoom testRoom = new RectangularRoom(new CM(10), new CM(20), new CM(30));
		assertThat(testRoom.getCeiling(), is(new CM2(200)));
	}

	@Test
	public void wallAreaOfARectangularRoomIsHeightMultipliedByTwoMultipliedByLengthPlusWidth() {
		RectangularRoom testRoom = new RectangularRoom(new CM(10), new CM(20), new CM(30));
		// Northern Wall/Southern wall: 10 * 30 each
		// West Wall/East Wall: 20 * 30 each
		// total: 300 + 300 + 600 + 600 = 1800
		assertThat(testRoom.getWall(), is(new CM2(1800)));
	}

}
