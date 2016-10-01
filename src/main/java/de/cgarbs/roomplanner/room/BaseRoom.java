/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import de.cgarbs.roomplanner.area.Area;

public interface BaseRoom {

	Area getFloor();
	
	Area getCeiling();
	
	Area getWall();
	
}
