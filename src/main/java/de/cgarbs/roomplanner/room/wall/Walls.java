/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import java.util.HashMap;
import java.util.Iterator;

import de.cgarbs.roomplanner.area.Area;

public class Walls extends HashMap<WallPosition, Wall>
{
	private static final long serialVersionUID = 1L;

	public Area getArea()
	{
		Iterator<Wall> iter = values().iterator();
		Area area = iter.next().getArea();
		while (iter.hasNext())
		{
			area = area.add(iter.next().getArea());
		}
		return area;
	}

}
