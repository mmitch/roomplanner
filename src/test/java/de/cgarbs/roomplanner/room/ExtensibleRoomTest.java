/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.extension.Extension;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.WallPosition;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.shape.GenericShape;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;
import de.cgarbs.roomplanner.test.stub.StubExtension;

public class ExtensibleRoomTest {

	@Test
	public void addingExtensionChangesFloorArea() {
		ExtensibleRoom testRoom = getTestRoom();
		assertThat(testRoom.add(getExtension()).getFloorArea(), is(new CM2(3)));
	}

	@Test
	public void addingExtensionChangesCeilingArea() {
		ExtensibleRoom testRoom = getTestRoom();
		assertThat(testRoom.add(getExtension()).getCeilingArea(), is(new CM2(5)));
	}

	@Test
	public void addingExtensionChangesWallArea() {
		ExtensibleRoom testRoom = getTestRoom();
		assertThat(testRoom.add(getExtension()).getWallArea(), is(new CM2(7)));
	}
	
	@Test
	public void addingMultipleExtensionsYieldsMultipleChanges() {
		ExtensibleRoom testRoom = getTestRoom();
		assertThat(testRoom.add(getExtension()).add(getExtension()).getFloorArea(), is(new CM2(4)));
	}

	/**
	 * returns a new room with floor=2cm², ceiling=3cm² and one wall with 4cm²
	 */
	private ExtensibleRoom getTestRoom() {
		Walls walls = new Walls();
		walls.put(WallPosition.EAST, new Wall(new CM(1), new CM(4)));
		
		return new ExtensibleRoom(
				new Floor(new CM(1), new CM(2)),
				new Ceiling(new CM(1), new CM(3)),
				walls
				);
	}

	/**
	 * returns a new extension with floor +1cm², ceiling +2cm² and first wall +3cm²
	 * @return
	 */
	private Extension getExtension() {
		return new StubExtension(
				new GenericShape(new CM2(1)),
				new GenericShape(new CM2(2)),
				new GenericShape(new CM2(3))
				);
	}

}
