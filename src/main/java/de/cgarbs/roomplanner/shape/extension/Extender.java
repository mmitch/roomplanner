/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape.extension;

import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Walls;

public interface Extender {

	void extendFloor(Floor floor);

	void extendCeiling(Ceiling ceiling);

	void extendWalls(Walls walls);

}