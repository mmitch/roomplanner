/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.pos.Position;
import de.cgarbs.roomplanner.room.extension.Extensible;
import de.cgarbs.roomplanner.shape.Rectangle;

public class Wall extends Extensible
{
	Length height;
	private Length length;
	private WallPosition position;
	private Position offset;

	public Wall(WallPosition position, Length length, Length height, Position offset)
	{
		super(new Rectangle(length, height));
		this.position = position;
		this.length = length;
		this.height = height;
		this.offset = offset;
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
}
