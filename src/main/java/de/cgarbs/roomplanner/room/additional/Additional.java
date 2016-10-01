/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.additional;

import de.cgarbs.roomplanner.area.Area;

public interface Additional {

	Area getFloor();
	Area getWall();
	Area getCeiling();
	
}
