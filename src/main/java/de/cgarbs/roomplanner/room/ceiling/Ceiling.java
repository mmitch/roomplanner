/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.ceiling;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.extension.Extensible;
import de.cgarbs.roomplanner.shape.Rectangle;

public class Ceiling extends Extensible {

	private Length northSouth;
	private Length eastWest;

	public Ceiling(Length northSouth, Length eastWest) {
		super(new Rectangle(northSouth, eastWest));
		this.northSouth = northSouth;
		this.eastWest = eastWest;
	}

	public Length getNorthSouthLength() {
		return northSouth;
	}

	public Length getEastWestLength() {
		return eastWest;
	}

}
