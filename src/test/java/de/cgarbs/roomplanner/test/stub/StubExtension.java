/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.test.stub;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.extension.Extension;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.Walls;
import de.cgarbs.roomplanner.shape.Shape;

public class StubExtension implements Extension {

	private Shape floorShape;
	private Shape ceilingShape;
	private Shape wallShape;
	
	public StubExtension(Shape floorShape, Shape ceilingShape, Shape wallShape) {
		this.floorShape = floorShape;
		this.ceilingShape = ceilingShape;
		this.wallShape = wallShape;
	}

	@Override
	public void extendFloor(Floor floor) {
		floor.add(floorShape);
	}

	@Override
	public void extendCeiling(Ceiling ceiling) {
		ceiling.add(ceilingShape);
	}

	@Override
	public void extendWalls(Walls walls) {
		firstWall(walls).add(wallShape);
	}

	private Wall firstWall(Walls walls) {
		return walls.values().iterator().next();
	}

}
