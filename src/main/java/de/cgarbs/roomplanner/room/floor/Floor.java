/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.floor;

import java.util.stream.Stream;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.HasFaces;
import de.cgarbs.roomplanner.room.extension.Extensible;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.wavefront.Face;
import de.cgarbs.wavefront.V;

public class Floor extends Extensible implements HasFaces
{
	private Face face;

	public Floor(Length northSouth, Length eastWest)
	{
		super(new Rectangle(northSouth, eastWest));
		this.face = calculateFace(northSouth, eastWest);
	}

	@Override
	public Stream<Face> faces()
	{
		return Stream.of(face);
	}

	private Face calculateFace(Length northSouth, Length eastWest)
	{
		double ns = northSouth.getInBaseUnit().doubleValue();
		double ew = eastWest.getInBaseUnit().doubleValue();
		return new Face( //
				new V(0, 0, 0), //
				new V(ns, 0, 0), //
				new V(ns, ew, 0), //
				new V(0, ew, 0) //
		);
	}

}
