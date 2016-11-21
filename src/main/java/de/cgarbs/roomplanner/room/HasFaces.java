/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.stream.Stream;

import de.cgarbs.wavefront.Face;

public interface HasFaces
{
	Stream<Face> faces();
}
