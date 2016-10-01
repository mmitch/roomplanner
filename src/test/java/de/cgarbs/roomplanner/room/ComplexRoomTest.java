/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.additional.Additional;
import de.cgarbs.roomplanner.test.stub.CM2;
import de.cgarbs.roomplanner.test.stub.StubAdditional;
import de.cgarbs.roomplanner.test.stub.StubRoom;

public class ComplexRoomTest {

	@Test
	public void floorAreaIsSummedUp() {
		Room baseRoom = new StubRoom(new CM2(10), new CM2(20), new CM2(30));
		Additional additional = new StubAdditional(new CM2(1), new CM2(2), new CM2(3));
		Room complexRoom = baseRoom.add(additional).add(additional);
		assertThat(complexRoom.getFloor(), is(new CM2(12)));
	}

	@Test
	public void wallAreaIsSummedUp() {
		Room baseRoom = new StubRoom(new CM2(10), new CM2(20), new CM2(30));
		Additional additional = new StubAdditional(new CM2(1), new CM2(2), new CM2(3));
		Room complexRoom = baseRoom.add(additional).add(additional);
		assertThat(complexRoom.getWall(), is(new CM2(24)));
	}

	@Test
	public void ceilingAreaIsSummedUp() {
		Room baseRoom = new StubRoom(new CM2(10), new CM2(20), new CM2(30));
		Additional additional = new StubAdditional(new CM2(1), new CM2(2), new CM2(3));
		Room complexRoom = baseRoom.add(additional).add(additional);
		assertThat(complexRoom.getCeiling(), is(new CM2(36)));
	}
}
