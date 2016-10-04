/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.floor;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.extension.Extensible;

public class Floor extends Extensible {

	public Floor(Length width, Length height) {
		super(new Rectangle(width, height));
	}

}
