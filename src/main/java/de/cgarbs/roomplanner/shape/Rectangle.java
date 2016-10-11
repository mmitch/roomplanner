/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape;

import de.cgarbs.roomplanner.length.Length;

public class Rectangle extends Shape {

	public Rectangle(Length width, Length height) {
		super(width.multiplyWith(height));
	}
	
}
