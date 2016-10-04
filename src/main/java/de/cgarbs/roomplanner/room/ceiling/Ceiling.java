/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.ceiling;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.extension.Extensible;

public class Ceiling extends Extensible {

	public Ceiling(Length width, Length height) {
		super(new Rectangle(width, height));
	}

}
