/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import java.util.Collections;
import java.util.List;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.room.HasFaces;
import de.cgarbs.roomplanner.room.extension.Extensible;
import de.cgarbs.roomplanner.shape.Rectangle;
import de.cgarbs.wavefront.Face;
import de.cgarbs.wavefront.V;

public class Wall extends Extensible implements HasFaces
{
	Length height;
	private Length length;
	private WallPosition position;
	private Position offset; // TODO: don't remember offset
	List<Face> faces;

	public Wall(WallPosition position, Length length, Length height, Position offset)
	{
		super(new Rectangle(length, height));
		this.position = position;
		this.length = length;
		this.height = height;
		this.offset = offset;
		this.faces = Collections.singletonList(calculateFace());
	}

	public Length getHeight()
	{
		return height;
	}

	public Length getLength()
	{
		return length;
	}

	public WallPosition getPosition()
	{
		return position;
	}

	public Position getOffset()
	{
		return offset;
	}

	@Override
	public List<Face> faces()
	{
		return faces;
	}

	private Face calculateFace()
	{
		double x1 = toDouble(offset.getEastWest());
		double y1 = toDouble(offset.getNorthSouth());

		double x2 = x1;
		double y2 = y1;
		switch (position)
		{
			case NORTH:
			case SOUTH:
				x2 += toDouble(length);
				break;
			case EAST:
			case WEST:
				y2 += toDouble(length);
				break;
		}

		double z1 = 0;
		double z2 = toDouble(height);

		return new Face( //
				new V(x1, y1, z1), //
				new V(x1, y1, z2), //
				new V(x2, y2, z2), //
				new V(x2, y2, z1) //
		);
	}

	private double toDouble(Length length)
	{
		return length.getInBaseUnit().doubleValue();
	}

}
