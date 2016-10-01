/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import de.cgarbs.roomplanner.room.additional.Additional;

public abstract class Room implements Additional {

	public Room add(Additional additional) {
		return new ComplexRoom(this, additional);
	}
	
}
