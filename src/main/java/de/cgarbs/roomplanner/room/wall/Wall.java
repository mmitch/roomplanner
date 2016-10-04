/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.roomplanner.shape.extension.Extensible;

public class Wall extends Extensible {

	Length height;

	public Wall(Length length, Length height) {
		super(new Rectangle(length, height));
		this.height = height;
	}

	public Length getHeight() {
		return height;
	}
}
